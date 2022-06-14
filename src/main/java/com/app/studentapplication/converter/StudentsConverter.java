package com.app.studentapplication.converter;

import com.app.studentapplication.dto.StudentsSaveRequestDto;
import com.app.studentapplication.entity.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentsConverter {


    public Students convertToStudents(StudentsSaveRequestDto studentsSaveRequestDto){
        Students students = new Students();
        students.setName(studentsSaveRequestDto.getName());
        students.setSurname(studentsSaveRequestDto.getSurname());
        students.setStudentImage(studentsSaveRequestDto.getStudentImage());
        return students;
    }
}
