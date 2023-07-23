package com.blogadmin.user.repository;


import com.blogadmin.user.entity.LoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginLogRepository extends JpaRepository<LoginLog, Long> {

    public List<LoginLog> findByChannelAndStatus(String channel,int status);
}
