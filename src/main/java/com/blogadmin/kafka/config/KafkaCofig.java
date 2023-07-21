package com.blogadmin.kafka.config;

import com.google.gson.Gson;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaCofig {

    @Bean
    public NewTopic createNewTopic(){
        return TopicBuilder
                .name("user-login")
                .build();
    }

    @Bean
    public NewTopic createCreateUserNewTopic(){
        return TopicBuilder
                .name("user-registration")
                .build();
    }


    @Bean
    public NewTopic createCreateBlogTopic(){
        return TopicBuilder
                .name("blog-details")
                .build();
    }

    @Bean
    public Gson getGson(){
        return new Gson();
    }
}
