package com.blogadmin.user.repository;

import com.blogadmin.user.entity.HitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HitLogRepository extends JpaRepository<HitLog,Long> {
}
