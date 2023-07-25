package com.blogadmin.user.serviecImp;

import com.blogadmin.common.dto.HitLogDto;
import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.daoServices.UserDao;
import com.blogadmin.user.dto.HitLogResponseDto;
import com.blogadmin.user.entity.HitLog;
import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.repository.HitLogRepository;
import com.blogadmin.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserServices implements UserService {


    private final UserDao userDao;

    @Autowired
    private HitLogRepository hitLogRepository;

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

    @Override
    public ResponseDto getAllHits() {


        List<HitLog> hitLogs = hitLogRepository.findAll();

        Map<LocalDate, Long> hitsPerDay = hitLogs.stream()
                .collect(Collectors.groupingBy(hitEntry -> hitEntry.getHitAt().toLocalDate(), Collectors.counting()));


        HitLogResponseDto hitLogResponseDto = HitLogResponseDto.builder()
                .totalHits((long)hitLogs.size())
                .hitsPerDay(hitsPerDay)
                .build();


        return ResponseDto.builder().data(hitLogResponseDto).build();
    }
}
