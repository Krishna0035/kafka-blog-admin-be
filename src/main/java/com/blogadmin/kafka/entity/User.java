package com.blogadmin.kafka.entity;

import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    private String firstName;

    private String lastName;

    private String profileId;

    private Long userId;


    public User(RegisterUserLogDto registerUserRequestDto) {
        this.email = registerUserRequestDto.getEmail();
        this.firstName = registerUserRequestDto.getFirstName();
        this.lastName = registerUserRequestDto.getLastName();
        this.profileId = registerUserRequestDto.getProfileId();
        this.userId = registerUserRequestDto.getId();
    }




}
