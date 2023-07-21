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

    private LocalDateTime createdAt;

    private Long createdBy;
}
