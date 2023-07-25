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
public class BlogLogDto {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdAt;

    private Long createdBy;

    private String createdByName;
}
