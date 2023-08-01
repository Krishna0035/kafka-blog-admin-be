package com.blogadmin.mailSender.serviceImpl;

import com.blogadmin.mailSender.service.MailServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailSenderServicesImpl implements MailServices {
    @Override
    public void sendListOfMail(List<String> listOfMail) {

        int listSize = 5;
        int numberOfTopic  = 3;

        int mid  = listSize / numberOfTopic;

        System.out.println(mid);







    }
}
