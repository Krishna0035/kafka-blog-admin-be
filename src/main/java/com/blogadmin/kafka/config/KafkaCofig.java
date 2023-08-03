package com.blogadmin.kafka.config;

import com.google.gson.Gson;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.web.client.RestTemplate;

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
    public NewTopic createBlogViewTopic(){
        return TopicBuilder
                .name("blog-view-details")
                .build();
    }


    @Bean
    public NewTopic createLikeBlogTopic(){
        return TopicBuilder
                .name("blog-like-details")
                .build();
    }


    @Bean
    public NewTopic createActivityBlogTopic(){
        return TopicBuilder
                .name("blog-activity-details")
                .build();
    }

    @Bean
    public NewTopic createHitsTopic(){
        return TopicBuilder
                .name("hits-details")
                .build();
    }

    @Bean
    public NewTopic createDemoTopic(){
        return TopicBuilder
                .name("demo")
                .build();
    }
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public Gson getGson(){
        return new Gson();
    }
}
