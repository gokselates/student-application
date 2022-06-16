package com.app.studentapplication.service;

import com.app.studentapplication.converter.StudentsConverter;
import com.app.studentapplication.dto.StudentsSaveRequestDto;
import com.app.studentapplication.entity.Students;
import com.app.studentapplication.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentsService {

    private final StudentRepository studentRepository;
    private final StudentsConverter studentsConverter;

    private Students students;

    public List<Students> getAllStudent()
    {
        List<Students> students = studentRepository.findAll();
        return students;
    }

    public Students save(StudentsSaveRequestDto studentsSaveRequestDto) {
            students = studentsConverter.convertToStudents(studentsSaveRequestDto);
            students = (Students) studentRepository.save(students);
        return students;
    }

    public Students update(StudentsSaveRequestDto studentsSaveRequestDto) {
        students = findById(studentsSaveRequestDto.getId());
        students.setName(studentsSaveRequestDto.getName());
        students.setSurname(studentsSaveRequestDto.getSurname());
        students.setStudentImage(studentsSaveRequestDto.getStudentImage());
        students = (Students) studentRepository.save(students);
        return students;
    }



    public Students findById(Long id){
        Optional byId = studentRepository.findById(id);
        return (Students) byId.get();
    }
}
