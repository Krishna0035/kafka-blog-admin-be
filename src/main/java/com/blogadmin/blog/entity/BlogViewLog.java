package com.blogadmin.blog.entity;

import com.blogadmin.blog.dto.BlogViewLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogViewLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long blogid;

    private Long viewedBy;

    private LocalDateTime viewedAt;

    public BlogViewLog(BlogViewLogDto blogViewLogDto) {
        this.blogid = blogViewLogDto.getBlogId();
        this.viewedBy = blogViewLogDto.getViewedBy();
        this.viewedAt = blogViewLogDto.getViewedAt();
    }
}
