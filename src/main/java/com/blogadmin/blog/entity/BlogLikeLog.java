package com.blogadmin.blog.entity;

import com.blogadmin.blog.dto.BlogLikeLogDto;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class BlogLikeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long blogid;

    private Long likedBy;

    private LocalDateTime likedAt;

    public BlogLikeLog(BlogLikeLogDto blogLikeLogDto) {
        this.blogid = blogLikeLogDto.getBlogId();
        this.likedBy = blogLikeLogDto.getLikedBy();
        this.likedAt = blogLikeLogDto.getLikedAt();
    }
}
