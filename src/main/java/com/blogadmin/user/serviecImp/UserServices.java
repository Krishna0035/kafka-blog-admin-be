package com.blogadmin.user.serviecImp;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.daoServices.UserDao;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.services.UserService;

public class UserServices implements UserService {


    private final UserDao userDao;

    public UserServices(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public ResponseDto getAllUser() {
        return ResponseDto
                .builder()
                .data(userDao.getAllUsers())
                .message("success")
                .status(true)
                .build();
    }

    @Override
    public ResponseDto getAllLogedInUser() {
        return null;
    }
}
