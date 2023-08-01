package com.blogadmin.mailSender.service;

import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

public interface MailServices {

    public void sendListOfMail(List<String> mail);

}
