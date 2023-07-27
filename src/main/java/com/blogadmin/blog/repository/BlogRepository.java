package com.blogadmin.blog.repository;

import com.blogadmin.blog.entity.Blog;
import com.blogadmin.blog.entity.BlogViewLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {

    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllByCreatedAtBetweenOrderByCreatedAtDesc(LocalDateTime startDate, LocalDateTime endDate);
}
