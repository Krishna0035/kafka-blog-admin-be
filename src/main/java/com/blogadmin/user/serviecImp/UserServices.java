package com.blogadmin.user.serviecImp;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.daoServices.UserDao;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
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
        List<List<LoginLog>> listOfAllLoginUser = new ArrayList<>();
        List<LoginLog> allLoginUserWithWeb = userDao.getAllLoginUserWithWeb();
        List<LoginLog> allLoginUserWithMobile = userDao.getAllLoginUserWithMobile();
        listOfAllLoginUser.add(allLoginUserWithMobile);
        listOfAllLoginUser.add(allLoginUserWithWeb);

        return ResponseDto.builder().data(listOfAllLoginUser).build();
    }
}
