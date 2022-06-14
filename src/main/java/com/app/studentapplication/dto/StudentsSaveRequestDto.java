package com.app.studentapplication.dto;

import lombok.Data;

@Data
public class StudentsSaveRequestDto {
    private Long id;
    private String name;
    private String surname;
    private byte[] studentImage;
}
