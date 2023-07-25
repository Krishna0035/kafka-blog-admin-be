package com.blogadmin.user.controller;


import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-user")
    public ResponseDto getAllUser(){
        return userService.getAllUser();
    }

    @GetMapping("/all-loged-In")
    public ResponseDto getAllLogedInUsers(){
        return userService.getAllLogedInUser();
    }



    @GetMapping("/all-hits")
    public ResponseDto getAllHits(){
        return userService.getAllHits();
    }



}
