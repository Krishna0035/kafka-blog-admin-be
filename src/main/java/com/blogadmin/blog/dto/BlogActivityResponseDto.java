package com.blogadmin.blog.dto;

import com.blogadmin.blog.entity.BlogActivityLog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
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
   public static class BlogActivities{

        private Long id;

        private Long blogId;

        private Long activityBy;

        private String activity;

        private LocalDateTime activityAt;

        private String activityByName;

        public BlogActivities(BlogActivityLog blogActivityLog) {
            this.id = blogActivityLog.getId();
            this.blogId = blogActivityLog.getBlogid();
            this.activityBy = blogActivityLog.getActivityBy();
            this.activity = blogActivityLog.getActivity();
            this.activityAt = blogActivityLog.getActivityAt();
            this.activityByName = blogActivityLog.getActivityByName();
        }
    }

}


