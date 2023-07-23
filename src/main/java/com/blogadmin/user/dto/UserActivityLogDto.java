package com.blogadmin.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserActivityLogDto {
    private Long userId;
    private String activity;
    private Long activityBy;
    private LocalDateTime activityAt;
}
