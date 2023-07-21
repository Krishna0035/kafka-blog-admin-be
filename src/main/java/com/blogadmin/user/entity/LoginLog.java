package com.blogadmin.user.entity;


import com.blogadmin.user.dto.LoginLogDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "login_log")
public class LoginLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use the appropriate strategy for your database (IDENTITY, SEQUENCE, etc.)
    private Long id;
    private String loginAt;
    private String channel;
    private Long userId;


    public LoginLog(LoginLogDto loginLogDto) {
        this.userId = loginLogDto.getId();
        this.channel = loginLogDto.getChannel();
        this.loginAt = loginLogDto.getChannel();
    }


}

