package com.app.studentapplication.dto;

import lombok.Data;

@Data
public class LessonsSaveRequestDto {
    private Long id;
    private String name;
    private Long quota;
}
