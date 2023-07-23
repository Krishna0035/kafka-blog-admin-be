package com.blogadmin.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetAllBlogRequestDto {

    private int offset;

    private int pageSize;

    private String sortBy;

    private String orderType;
}
