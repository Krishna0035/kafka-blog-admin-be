package com.blogadmin.kafka.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginLogDto {

        private Long id;
        private LocalDateTime loginAt;
        private String channel;

}
