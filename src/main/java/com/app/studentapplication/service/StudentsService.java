package com.app.studentapplication.service;

import com.app.studentapplication.converter.StudentsConverter;
import com.app.studentapplication.dto.StudentsSaveRequestDto;
import com.app.studentapplication.entity.Students;
import com.app.studentapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;
    private final StudentsConverter studentsConverter;

    private Students students;

    public List<Students> getAllStudent()
    {
        List<Students> students = new ArrayList<Students>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

    public Students save(StudentsSaveRequestDto studentsSaveRequestDto) {
            students = studentsConverter.convertToStudents(studentsSaveRequestDto);
            students = studentRepository.save(students);
        return students;
    }

    public Students update(StudentsSaveRequestDto studentsSaveRequestDto) {
        students = findById(studentsSaveRequestDto.getId());
        students.setName(studentsSaveRequestDto.getName());
        students.setSurname(studentsSaveRequestDto.getSurname());
        students.setStudentImage(studentsSaveRequestDto.getStudentImage());
        students = studentRepository.save(students);
        return students;
    }



    public Students findById(Long id){
        return studentRepository.findById(id).get();
    }
}
