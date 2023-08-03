package com.blogadmin.mailSender.serviceImpl;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.kafka.producer.KafkaProducer;
import com.blogadmin.mailSender.dto.EmailDto;
import com.blogadmin.mailSender.dto.EmailResponseDto;
import com.blogadmin.mailSender.dto.KafkaEmailDto;
import com.blogadmin.mailSender.dto.SendMailDto;
import com.blogadmin.mailSender.service.MailServices;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MailSenderServicesImpl implements MailServices {

    private List<String> topics = List.of("email_topic_new_1","email_topic_new_2","email_topic_new_3");

    @Autowired
    private KafkaProducer kafkaProducer;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Gson gson;


    @Override
    public void sendListOfMail(EmailDto emailDto) {

        int listSize = 5;
        int numberOfTopic  = 3;

        int mid  = listSize / numberOfTopic;

        System.out.println(mid);


        int rem = emailDto.getListOfMail().size()%topics.size();

        int seg = emailDto.getListOfMail().size()/topics.size();

        int j=0,i=0;
        while(i< emailDto.getListOfMail().size()-rem){

            KafkaEmailDto kafkaEmailDto = KafkaEmailDto.builder()
                    .email(emailDto.getListOfMail().get(i))
                    .body(emailDto.getBody())
                    .subject(emailDto.getSubject())
                    .build();

            kafkaProducer.sendMessage(kafkaEmailDto,topics.get(j));

            System.out.println(emailDto.getListOfMail().get(i)+" sent to "+topics.get(j));

            if((i+1)%seg==0){
                j++;
            }
            i++;
        }
        j=0;
        while (i<emailDto.getListOfMail().size()){
            KafkaEmailDto kafkaEmailDto = KafkaEmailDto.builder()
                    .email(emailDto.getListOfMail().get(i))
                    .body(emailDto.getBody())
                    .subject(emailDto.getSubject())
                    .build();
            kafkaProducer.sendMessage(kafkaEmailDto,topics.get(j));
            System.out.println(emailDto.getListOfMail().get(i)+" sent to "+topics.get(j));
            i++;
            j++;
        }


    }

    @Override
    public void sendMail(EmailDto emailDto) {


        String apiUrl = "http://localhost:8083/send"; // Replace this with the actual API URL

        // Create headers with Content-Type application/json
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);


        for(String to : emailDto.getListOfMail()){
            // Create the request body (JSON payload in this example)

            SendMailDto sendMailDto = SendMailDto.builder()
                    .recipients(List.of(to))
                    .subject(emailDto.getSubject())
                    .body(emailDto.getBody())
                    .build();



            String requestBody = gson.toJson(sendMailDto); // Replace this with your actual JSON payload

            // Create the HttpEntity with headers and body
            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            // Make the POST request
            ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, requestEntity, String.class);

            if (response.getStatusCode().is2xxSuccessful()) {
                String responseData = response.getBody();
                // Process the responseData here
            } else {
                // Handle error scenario
                System.out.println("API call failed with status code: " + response.getStatusCodeValue());
            }
        }



    }

    @Override
    public ResponseDto sendEmailGeneral(EmailDto emailDto) {

        LocalDateTime startTime = LocalDateTime.now();

        if(emailDto.isUsingKafka()){
            sendListOfMail(emailDto);
        }else {
            sendMail(emailDto);
        }

        LocalDateTime endTime = LocalDateTime.now();

        Duration duration = Duration.between(startTime, endTime);

        long seconds = duration.toMillis();

        EmailResponseDto emailResponseDto = EmailResponseDto.builder().timeTaken(seconds).build();

         return ResponseDto.builder().data(emailResponseDto).message("Success").status(true).build();
    }
}
