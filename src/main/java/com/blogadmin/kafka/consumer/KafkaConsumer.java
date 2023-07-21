package com.blogadmin.kafka.consumer;

import com.blogadmin.blog.dto.BlogLogDto;
import com.blogadmin.blog.service.BlogService;



import com.blogadmin.user.dto.LoginLogDto;
import com.blogadmin.user.dto.RegisterUserLogDto;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.repository.LoginLogRepository;
import com.blogadmin.user.repository.UserRepository;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class KafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);


    @Autowired
    private Gson gson;

    @Autowired
    private BlogService blogService;

    private final UserRepository userRepository;
    private final LoginLogRepository loginLogRepository;

    public KafkaConsumer(UserRepository userRepository,
                         LoginLogRepository loginLogRepository) {
        this.userRepository = userRepository;
        this.loginLogRepository = loginLogRepository;
    }


    @KafkaListener(topics = "user-login" , groupId = "myGroup")
    public void receiveJsonMessage(String  user) {
        LOGGER.info("user logged in   " + user);
        Gson gson = new Gson();

        LoginLogDto loginLog = gson.fromJson(user, LoginLogDto.class);




        // Access the fields
        Long id = loginLog.getId();
        LocalDateTime loginAt = loginLog.getLoginAt();

        // Access the fields
        String channel = loginLog.getChannel();
        loginLogRepository.save(new LoginLog(loginLog));
    }

    @KafkaListener(topics = "user-registration" , groupId = "myGroup")
    public void receiveRegisterUserJsonMessage(String  user) {
        LOGGER.info("new User registered   " + user);


        RegisterUserLogDto registerUserLogDto = gson.fromJson(user, RegisterUserLogDto.class);

        // Access the fields
        Long id = registerUserLogDto.getId();
        String email = registerUserLogDto.getEmail();
        String profileId = registerUserLogDto.getProfileId();
        String firstName = registerUserLogDto.getFirstName();
        String lastName = registerUserLogDto.getLastName();

        // Use the fields as needed
        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("Profile ID: " + profileId);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

         User newRegistered  = new User(registerUserLogDto);
        userRepository.save(newRegistered);
        System.out.println("done");


    }

    @KafkaListener(topics = "blog-details" , groupId = "myGroup")
    public void receiveCreateBlogJsonMessage(String  blog) {
        LOGGER.info("blog created   " + blog);


        BlogLogDto blogLogDto = gson.fromJson(blog, BlogLogDto.class);

        blogService.createBlogLog(blogLogDto);

        LOGGER.info("blog saved to db   " + blog);
    }

}
