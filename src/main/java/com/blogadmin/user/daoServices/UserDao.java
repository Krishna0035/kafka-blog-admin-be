package com.blogadmin.user.daoServices;

import com.blogadmin.user.entity.User;
import com.blogadmin.user.repository.UserRepository;

import java.util.List;

public class UserDao {

    private final UserRepository userRepository;


    public UserDao(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


}
