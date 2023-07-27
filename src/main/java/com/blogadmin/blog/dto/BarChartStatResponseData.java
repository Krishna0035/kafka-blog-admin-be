package com.blogadmin.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BarChartStatResponseData {

   private BarChatData blogPost;

   private BarChatData blogView;

   private List<LocalDate> dates;

}
