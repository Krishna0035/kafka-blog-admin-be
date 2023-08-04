package com.blogadmin.user.serviecImp;

import ch.qos.logback.core.util.Loader;
import com.blogadmin.common.dto.HitLogDto;
import com.blogadmin.common.dto.ResponseDto;
import com.blogadmin.user.daoServices.UserDao;
import com.blogadmin.user.dto.BarChartStatResponseData;
import com.blogadmin.user.dto.BarChatData;
import com.blogadmin.user.dto.HitLogResponseDto;
import com.blogadmin.user.entity.HitLog;

import com.blogadmin.user.dto.UserActivityResDto;

import com.blogadmin.user.entity.LoginLog;
import com.blogadmin.user.entity.User;
import com.blogadmin.user.repository.HitLogRepository;
import com.blogadmin.user.services.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
                .totalHits((long) hitLogs.size())
                .hitsPerDay(hitsPerDay)
                .build();


        return ResponseDto.builder().data(hitLogResponseDto).build();
    }

    public ResponseDto getAUserWithActivity(Long userId) {
        UserActivityResDto aUserAndActivity = userDao.getAUserAndActivity(userId);
      return ResponseDto.builder().status(true).message("success").data(aUserAndActivity).build();


    }

    @Override
    public ResponseDto getAllUserBasedOnPlateForm() {

        Long days = 7L;
//
        LocalDateTime localDateTime = LocalDateTime.now().minusDays(days);


        List<LoginLog> loginLogs = userDao.fetchUserBetweenTwoDates(LocalDateTime.now().minusDays(days), LocalDateTime.now());


        List<LoginLog> webUser = loginLogs.stream().filter(e -> e.getChannel().equals("web")).collect(Collectors.toList());
        List<LoginLog> appUser = loginLogs.stream().filter(e -> e.getChannel().equals("app")).collect(Collectors.toList());

//        List<Integer> webCount = new ArrayList<>();
//        List<Integer> appCount = new ArrayList<>();



        Map<LocalDate, Long> webCount  = webUser.stream().collect(Collectors.groupingBy(web -> web.getLoginAt().toLocalDate(), Collectors.counting()));
        Map<LocalDate, Long> appCount = appUser.stream().collect(Collectors.groupingBy(app -> app.getLoginAt().toLocalDate(), Collectors.counting()));



        List<Map<LocalDate, Long>> list = new ArrayList<>();
        list.add(webCount);

        list.add(appCount);

        List<Long> listOfWeb = new ArrayList<>();
        List<Long> listOfApp = new ArrayList<>();
        List<LocalDate> listOfDates = new ArrayList<>();
        for(Long i = 0L;i<=days;i++){

            Long current = days - i;

            listOfDates.add(LocalDate.now().minusDays(current));
            if(webCount.containsKey(LocalDate.now().minusDays(current))){
                System.out.println("yes here data  " + webCount.get(LocalDate.now().minusDays(current)));

                System.out.println(webCount.get(LocalDate.now().minusDays(current)));
                listOfWeb.add(webCount.get(LocalDate.now().minusDays(current)));
            }else{
                listOfWeb.add(0L);
            }


            if(appCount.containsKey(LocalDate.now().minusDays(current))){
                System.out.println("yes here data  " + appCount.get(LocalDate.now().minusDays(current)));

                System.out.println(appCount.get(LocalDate.now().minusDays(current)));
                listOfApp.add(appCount.get(LocalDate.now().minusDays(current)));
            }else{
                listOfApp.add(0L);
            }

        }

        System.out.println("+++++++++++++++++++++++++++");
        System.out.println(listOfWeb);
        System.out.println(listOfApp);
        System.out.println(listOfDates);

        BarChartStatResponseData barChartStatResponseData = new BarChartStatResponseData();
        BarChatData barChatDataForWeb = new BarChatData();
        barChatDataForWeb.setData(listOfWeb);
        barChatDataForWeb.setName("web");

        barChartStatResponseData.setUserFromWeb(barChatDataForWeb);

        BarChatData barChatDataForApp = new BarChatData();
        barChatDataForApp.setData(listOfApp);
        barChatDataForApp.setName("app");

        barChartStatResponseData.setUserFromApp(barChatDataForApp);

        barChartStatResponseData.setDates(listOfDates);





        return ResponseDto.builder().data(barChartStatResponseData).status(true).message("scuess").build();
    }
}
