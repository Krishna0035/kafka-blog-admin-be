package com.blogadmin.mailSender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KafkaEmailDto {

    private String email;

    private String subject;

    private String body;

}
