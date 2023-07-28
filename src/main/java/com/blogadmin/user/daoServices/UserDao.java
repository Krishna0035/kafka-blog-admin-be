package com.blogadmin.user.daoServices;

import com.blogadmin.user.dto.UserActivityResDto;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.entity.UserActivity;
import com.blogadmin.user.repository.LoginLogRepository;
import com.blogadmin.user.repository.UserActivityRepository;
import com.blogadmin.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserDao {

    private final UserRepository userRepository;
    private final LoginLogRepository loginLogRepository;
    private final UserActivityRepository userActivityRepository;



    public UserDao(UserRepository userRepository,
                   LoginLogRepository loginLogRepository,
                   UserActivityRepository userActivityRepository) {
        this.userRepository = userRepository;
        this.loginLogRepository = loginLogRepository;
        this.userActivityRepository = userActivityRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<LoginLog> getAllLoginUser() {
        return loginLogRepository.findAll();
    }

    public List<LoginLog> getAllLoginUserWithMobile() {
        return loginLogRepository.findByChannelAndStatus("mobile",1);
    }

    public List<LoginLog> getAllLoginUserWithWeb() {
        return loginLogRepository.findByChannelAndStatus("web",1);
    }

    public void saveUserActivity(UserActivity userActivity){
        userActivityRepository.save(userActivity);
    }


    public UserActivityResDto getAUserAndActivity(Long userId) {


      return UserActivityResDto
                .builder()
                .user(userById(userId))
                .userActivityList(fetchUserActivity(userId))
                .build();

    }

    public User userById(Long userId)  {
        Optional<User> user = userRepository.findByUserId(userId);
        if(user.isPresent()){
            return user.get();
        }
        else{
            throw new RuntimeException("user not found");
        }
    }

    public List<UserActivity> fetchUserActivity(Long userId) {
       return userActivityRepository.findByActivityBy(userId);
    }


    public List<LoginLog> fetchUserBetweenTwoDates(LocalDateTime start,LocalDateTime end){
        return loginLogRepository.findAllByLoginAtBetweenOrderByLoginAtDesc(start,end);
    }




}


