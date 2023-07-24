package com.blogadmin.blog.repository;

import com.blogadmin.blog.dto.RecordCountDTO;
import com.blogadmin.blog.entity.BlogActivityLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface BlogActivityRepository extends JpaRepository<BlogActivityLog,Long> {

//    @Query("SELECT blogid, MAX(activity_at) AS last_activity " +
//            "FROM blog_activity_log where blogid in :blogIdList " +
//            "GROUP BY blogid")
//    List<BlogActivityLog> findLastActivityByBlogIds(List<Long> blogIdList);

//    @Query("SELECT new com.blogadmin.blog.dto.RecordCountDTO(DATE_FORMAT(bal.activityAt, '%Y-%m-%d %H:00:00'), COUNT(bal.id)) " +
//            "FROM BlogActivityLog bal " +
//            "WHERE bal.activityAt >= :fromTime " +
//            "GROUP BY DATE_FORMAT(bal.activityAt, '%Y-%m-%d %H:00:00') " +
//            "ORDER BY DATE_FORMAT(bal.activityAt, '%Y-%m-%d %H:00:00')")
//    List<RecordCountDTO> findRecordCountsForEachHour(LocalDateTime fromTime);


    List<BlogActivityLog> findByBlogidOrderByActivityAtDesc(Long blogid);
}
