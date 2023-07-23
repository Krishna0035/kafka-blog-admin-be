package com.blogadmin.blog.repository;

import com.blogadmin.blog.entity.BlogLikeLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogLikeLogRepository extends JpaRepository<BlogLikeLog,Long> {

    public List<BlogLikeLog> findAllByBlogidIn(List<Long> blogId);
}
