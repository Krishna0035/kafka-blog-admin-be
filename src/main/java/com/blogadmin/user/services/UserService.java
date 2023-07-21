package com.blogadmin.user.services;

import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;

public interface UserService {

    public ResponseDto getAllUser();

    public ResponseDto getAllLogedInUser();

}
