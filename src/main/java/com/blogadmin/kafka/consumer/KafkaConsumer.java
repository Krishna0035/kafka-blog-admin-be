package com.blogadmin.kafka.consumer;

import com.blogadmin.blog.dto.UserActivityLogDto;
import com.blogadmin.blog.dto.BlogLikeLogDto;
import com.blogadmin.blog.dto.BlogLogDto;
import com.blogadmin.blog.dto.BlogViewLogDto;
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

    // login track

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

    // user registration track

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


    // new blog track

    @KafkaListener(topics = "blog-details" , groupId = "myGroup")
    public void receiveCreateBlogJsonMessage(String  blog) {
        LOGGER.info("blog created   " + blog);


        BlogLogDto blogLogDto = gson.fromJson(blog, BlogLogDto.class);

        blogService.createBlogLog(blogLogDto);

        LOGGER.info("blog saved to db   " + blog);
    }





    // blog view track


    @KafkaListener(topics = "blog-view-details" , groupId = "myGroup")
    public void receiveViewBlogJsonMessage(String  blog) {
        LOGGER.info("blog created   " + blog);


        BlogViewLogDto blogViewLogDto = gson.fromJson(blog, BlogViewLogDto.class);

        blogService.viewBlog(blogViewLogDto);

        LOGGER.info("blog saved to db   " + blog);
    }


    // blog like track


    @KafkaListener(topics = "blog-like-details" , groupId = "myGroup")
    public void receiveLikeBlogJsonMessage(String  blog) {
        LOGGER.info("blog created   " + blog);


        BlogLikeLogDto blogLikeLogDto = gson.fromJson(blog, BlogLikeLogDto.class);

        blogService.likeBlog(blogLikeLogDto);

        LOGGER.info("blog saved to db   " + blog);
    }




    // a particular blog activity track


    @KafkaListener(topics = "blog-activity-details" , groupId = "myGroup")
    public void receiveActivityBlogJsonMessage(String  blog) {
        LOGGER.info("blog created   " + blog);


        UserActivityLogDto blogActivityLogDto = gson.fromJson(blog, UserActivityLogDto.class);

        blogService.blogActivity(blogActivityLogDto);

        LOGGER.info("blog saved to db   " + blog);
    }

    @KafkaListener(topics = "user-activity-details" , groupId = "myGroup")
    public void receiveActivityUserJsonMessage(String  userActivity) {
        LOGGER.info("user created   " + userActivity);


        UserActivityLogDto userActivityLogDto = gson.fromJson(userActivity, UserActivityLogDto.class);

        blogService.blogActivity(userActivityLogDto);

        LOGGER.info("user saved to db   " + userActivity);
    }

    // total hits and hits/day

}
