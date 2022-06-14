package com.app.studentapplication.service;

import com.app.studentapplication.dto.StudentLessonsSaveRequestDto;
import com.app.studentapplication.entity.Students;
import com.app.studentapplication.entity.StudentsLessons;
import com.app.studentapplication.repository.StudentsLessonsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentLessonsService {

    private final StudentsLessonsRepository studentsLessonsRepository;


    public StudentsLessons save(StudentLessonsSaveRequestDto studentLessonsSaveRequestDto) {
        StudentsLessons studentsLessons = new StudentsLessons();
        studentsLessons.setId_lessons(studentLessonsSaveRequestDto.getId_lessons());
        studentsLessons.setId_students(studentLessonsSaveRequestDto.getId_students());

        studentsLessons = studentsLessonsRepository.save(studentsLessons);
        return studentsLessons;
    }

    public void delete(StudentLessonsSaveRequestDto studentLessonsSaveRequestDto){
        Long id_lessons = studentLessonsSaveRequestDto.getId_lessons();
        Long id_students = studentLessonsSaveRequestDto.getId_students();
        studentsLessonsRepository.deleteStudentsLessonsByIdLessonsAndIdStudents(id_lessons,id_students);
    }

    public Long findAllStudentsCountByIdLesson(Long id_Lesson){
        return studentsLessonsRepository.findAllStudentsCountByIdLesson(id_Lesson);
    }

    public List<Students> findAllStudentsByIdLesson(Long id_Lesson){

        return studentsLessonsRepository.findAllStudentsByIdLesson(id_Lesson);
    }

}
