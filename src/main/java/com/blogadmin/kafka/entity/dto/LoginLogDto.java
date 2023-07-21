package com.blogadmin.kafka.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLogDto {

        private Long id;
        private String loginAt;
        private String channel;

}
