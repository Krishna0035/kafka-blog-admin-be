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
public class SendMailDto {
   private List<String> recipients;

   private String subject;

   private String body;
}
