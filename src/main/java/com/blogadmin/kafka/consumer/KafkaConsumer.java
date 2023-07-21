package com.blogadmin.kafka.consumer;

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
    }

}
