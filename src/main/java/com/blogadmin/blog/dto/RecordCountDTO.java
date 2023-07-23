package com.blogadmin.blog.dto;

public class RecordCountDTO {
    private String hour;
    private long recordCount;

    public RecordCountDTO(String hour, long recordCount) {
        this.hour = hour;
        this.recordCount = recordCount;
    }

    // Getters and setters (or lombok annotations) go here
}
