package com.blogadmin.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogActivityResponseDto {

    private BlogLogResponseDto blogLogResponseDto;

    private List<BlogActivities> blogActivities;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
   static class BlogActivities{

        private Long id;

        private Long blogId;

        private Long activityBy;

        private String activity;

        private String activityAt;


    }

}


