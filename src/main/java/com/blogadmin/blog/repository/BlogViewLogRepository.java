package com.blogadmin.blog.repository;

import com.blogadmin.blog.entity.BlogViewLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BlogViewLogRepository extends JpaRepository<BlogViewLog,Long> {

    public List<BlogViewLog> findAllByBlogidIn(List<Long> blogId);

    public List<BlogViewLog> findAllByBlogid(Long blogId);

    public List<BlogViewLog> findAllByViewedAt(LocalDateTime viewedAt);

    List<BlogViewLog> findAllByViewedAtBetweenOrderByViewedAtDesc(LocalDateTime startDate, LocalDateTime endDate);
}
