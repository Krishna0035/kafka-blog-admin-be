package com.blogadmin.blog.dto;

import com.blogadmin.blog.entity.Blog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogLogResponseDto {

    private Long id;

    private String title;

    private LocalDateTime createdAt;

    private LocalDateTime lastActivityAt;

    private String lastActivity;

    private Long createdBy;


    private Long totalViews;


    private Long totalLikes;


    public BlogLogResponseDto(Blog blog,LocalDateTime lastActivityAt,String lastActivity, Long totalViews, Long totalLikes) {
        this.id = blog.getId();
        this.title = blog.getTitle();
        this.createdAt = blog.getCreatedAt();
        this.lastActivityAt = lastActivityAt;
        this.lastActivity = lastActivity;
        this.createdBy = blog.getCreatedBy();
        this.totalViews = totalViews;
        this.totalLikes = totalLikes;
    }
}
