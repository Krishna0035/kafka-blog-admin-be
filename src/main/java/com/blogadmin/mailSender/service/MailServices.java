package com.blogadmin.mailSender.service;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.mailSender.dto.EmailDto;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

public interface MailServices {

    public void sendListOfMail(EmailDto emailDto);

    public void  sendMail(EmailDto emailDto);

    public ResponseDto sendEmailGeneral(EmailDto emailDto);

}
