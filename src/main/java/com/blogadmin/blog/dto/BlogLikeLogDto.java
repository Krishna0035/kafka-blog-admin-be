package com.blogadmin.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogLikeLogDto {

    private Long id;

    private Long blogId;

    private Long likedBy;

    private String activityByName;

    private LocalDateTime likedAt;
}
