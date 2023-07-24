package com.blogadmin.user.entity;

import com.blogadmin.user.dto.RegisterUserLogDto;
import com.blogadmin.user.dto.UserActivityLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String activity;
    private Long activityBy;
    private LocalDateTime activityAt;

    public UserActivity(UserActivityLogDto userActivityLogDto) {
        this.userId = userActivityLogDto.getUserId();
        this.activity = userActivityLogDto.getActivity();
        this.activityBy = userActivityLogDto.getActivityBy();
        this.activityAt = userActivityLogDto.getActivityAt();
    }
}
