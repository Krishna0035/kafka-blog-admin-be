package com.blogadmin.kafka.producer;



import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String ,String> kafkaTemplate;


    public void sendMessage(Object object,String topic){

//        Message<Object> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,"demo").build();

//        kafkaTemplate.send(topic,object);

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(object);
        kafkaTemplate.send(topic, jsonMessage);

    }

    public void sendMessage(Object object,String topic,Integer partition){

//        Message<Object> message = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC,"demo").build();

//        kafkaTemplate.send(topic,object);

        Gson gson = new Gson();
        String jsonMessage = gson.toJson(object);
        kafkaTemplate.send(topic,partition,null, jsonMessage);

    }
}
