package com.blogadmin.user.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HitLogResponseDto {

    private Long totalHits;

    Map<LocalDate,Long> hitsPerDay;
}
