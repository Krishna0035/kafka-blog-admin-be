package com.blogadmin.blog.entity;

import com.blogadmin.blog.dto.BlogActivityLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BlogActivityLog {

    @Id
    private Long id;

    private Long blogid;

    private String activity;

    private Long activityBy;

    private LocalDateTime activityAt;

    public BlogActivityLog(BlogActivityLogDto blogActivityLogDto) {
        this.blogid = blogActivityLogDto.getBlogId();
        this.activity = blogActivityLogDto.getActivity();
        this.activityBy = blogActivityLogDto.getActivityBy();
        this.activityAt = blogActivityLogDto.getActivityAt();
    }
}
