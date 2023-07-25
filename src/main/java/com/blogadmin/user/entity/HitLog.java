package com.blogadmin.user.entity;


import com.blogadmin.common.dto.HitLogDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class HitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pageInfo;

    private LocalDateTime hitAt;

    public HitLog(HitLogDto hitLogDto) {
        this.pageInfo = hitLogDto.getPageInfo();
        this.hitAt = hitLogDto.getHitAt();
    }
}
