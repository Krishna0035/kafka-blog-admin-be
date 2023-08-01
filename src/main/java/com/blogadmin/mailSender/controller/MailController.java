package com.blogadmin.mailSender.controller;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.mailSender.service.MailServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController {


    private final MailServices mailServices;

    public MailController(MailServices mailServices) {
        this.mailServices = mailServices;
    }


    @PostMapping("/send-mail")
    public ResponseDto sendMail(@RequestBody List<String> listOfMail){
         mailServices.sendListOfMail(listOfMail);
         return null;
    }


}
