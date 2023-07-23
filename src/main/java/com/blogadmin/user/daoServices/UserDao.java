package com.blogadmin.user.daoServices;

import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.repository.LoginLogRepository;
import com.blogadmin.user.repository.UserRepository;

import java.util.List;

public class UserDao {

    private final UserRepository userRepository;
    private final LoginLogRepository loginLogRepository;


    public UserDao(UserRepository userRepository,
                   LoginLogRepository loginLogRepository) {
        this.userRepository = userRepository;
        this.loginLogRepository = loginLogRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<LoginLog> getAllLoginUser() {
        return loginLogRepository.findAll();
    }

    public List<LoginLog> getAllLoginUserWithMobile() {
        return loginLogRepository.findByChannel("mobile");
    }

    public List<LoginLog> getAllLoginUserWithWeb() {
        return loginLogRepository.findByChannel("mobile");
    }

}


