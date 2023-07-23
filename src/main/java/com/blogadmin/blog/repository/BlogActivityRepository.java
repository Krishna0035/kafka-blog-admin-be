package com.blogadmin.blog.repository;

import com.blogadmin.blog.entity.BlogActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogActivityRepository extends JpaRepository<BlogActivityLog,Long> {

    @Query("SELECT bal FROM BlogActivityLog bal WHERE bal.blogid IN :blogIdList AND bal.activityAt = (" +
            "SELECT MAX(bal2.activityAt) FROM BlogActivityLog bal2 WHERE bal2.blogid = bal.blogid)")
    List<BlogActivityLog> findLastActivityByBlogIds(List<Long> blogIdList);
}
