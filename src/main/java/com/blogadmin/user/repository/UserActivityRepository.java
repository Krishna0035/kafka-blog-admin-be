package com.blogadmin.user.repository;

import com.blogadmin.user.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity, Long> {

}
