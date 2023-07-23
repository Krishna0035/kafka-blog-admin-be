package com.blogadmin.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogViewLogDto {

    private Long blogId;

    private Long viewedBy;

    private LocalDateTime viewedAt;



}
