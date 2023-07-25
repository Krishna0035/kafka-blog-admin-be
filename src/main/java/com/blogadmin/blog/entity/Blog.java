package com.blogadmin.blog.entity;


import com.blogadmin.blog.dto.BlogLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Blog {

    @Id
    private Long id;

    private String title;

    private String description;

    private String createdByName;

    private LocalDateTime createdAt;

    private Long createdBy;


    public Blog(BlogLogDto blogLogDto){
        this.id=blogLogDto.getId();
        this.title=blogLogDto.getTitle();
        this.createdAt=blogLogDto.getCreatedAt();
        this.createdBy=blogLogDto.getCreatedBy();
        this.description=blogLogDto.getDescription();
        this.createdByName=blogLogDto.getCreatedByName();
    }
}
