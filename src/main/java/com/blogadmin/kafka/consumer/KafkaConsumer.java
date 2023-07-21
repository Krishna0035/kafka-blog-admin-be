package com.blogadmin.kafka.consumer;

import com.blogadmin.kafka.entity.RegisterUserLogDto;
import com.blogadmin.kafka.entity.User;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @KafkaListener(topics = "user-login" , groupId = "myGroup")
    public void receiveJsonMessage(String  user) {
        LOGGER.info("user logged in   " + user);


    }

    @KafkaListener(topics = "user-registration" , groupId = "myGroup")
    public void receiveRegisterUserJsonMessage(String  user) {
        LOGGER.info("new User registered   " + user);



        Gson gson = new Gson();

        RegisterUserLogDto registerUserLogDto = gson.fromJson(user, RegisterUserLogDto.class);

        // Access the fields
        Long id = registerUserLogDto.getId();
        String email = registerUserLogDto.getEmail();
        String profileId = registerUserLogDto.getProfileId();
        String firstName = registerUserLogDto.getFirstName();
        String lastName = registerUserLogDto.getLastName();

        // Use the fields as needed
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Profile ID: " + profileId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

         User newRegistered  = new User(registerUserLogDto);





    }



}
