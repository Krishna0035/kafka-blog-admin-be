package com.blogadmin.user.services;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import org.springframework.stereotype.Service;


public interface UserService {

    public ResponseDto getAllUser();

    public ResponseDto getAllLogedInUser();


    public ResponseDto getAllHits();

    public ResponseDto getAUserWithActivity(Long userId);

    public ResponseDto getAllUserBasedOnPlateForm();


}
