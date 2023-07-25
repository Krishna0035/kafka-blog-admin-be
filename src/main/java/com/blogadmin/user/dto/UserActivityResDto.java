package com.blogadmin.user.dto;

import com.blogadmin.user.entity.User;
import com.blogadmin.user.entity.UserActivity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserActivityResDto {
    private User user;
    private List<UserActivity> userActivityList;

}
