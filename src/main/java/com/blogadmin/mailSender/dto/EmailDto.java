package com.blogadmin.mailSender.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmailDto {

    private List<String> listOfMail;

    private String subject;

    private String body;

    private boolean usingKafka;
}
