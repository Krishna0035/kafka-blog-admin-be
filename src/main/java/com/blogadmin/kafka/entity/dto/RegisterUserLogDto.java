package com.blogadmin.kafka.entity.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterUserLogDto {

    private Long id;

    private String email;

    private String profileId;

    private String firstName;

    private String lastName;
}