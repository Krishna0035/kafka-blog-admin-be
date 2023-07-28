package com.blogadmin.user.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarChartStatResponseData {

   private BarChatData userFromWeb;

   private BarChatData userFromApp;

   private List<LocalDate> dates;

}
