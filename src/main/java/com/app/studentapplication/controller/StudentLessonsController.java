package com.app.studentapplication.controller;

import com.app.studentapplication.dto.StudentLessonsSaveRequestDto;
import com.app.studentapplication.dto.StudentRequestDto;
import com.app.studentapplication.entity.Students;
import com.app.studentapplication.entity.StudentsLessons;
import com.app.studentapplication.response.RestResponse;
import com.app.studentapplication.service.LessonsService;
import com.app.studentapplication.service.StudentLessonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//creating RestController
@RestController
@RequiredArgsConstructor
public class StudentLessonsController {

    private final StudentLessonsService studentLessonsService;
    private final LessonsService lessonsService;

    @PostMapping(path = "/api/v1/addStudentLesson")
    public ResponseEntity addStudentLesson(@RequestBody StudentLessonsSaveRequestDto studentLessonsSaveRequestDto){

        Long lessonQuota = lessonsService.getLessonQuota(studentLessonsSaveRequestDto);
        Long studentsCountByIdLesson = studentLessonsService.findAllStudentsCountByIdLesson(studentLessonsSaveRequestDto.getId_lessons());

        if(studentsCountByIdLesson >= lessonQuota) {
            RestResponse restResponse = new RestResponse();
            restResponse.setMessages("Full Quota");
            return ResponseEntity.ok(restResponse);
        }

        StudentsLessons savedStudentsLessons = studentLessonsService.save(studentLessonsSaveRequestDto);
        return ResponseEntity.ok(RestResponse.of(savedStudentsLessons));
    }

    @PostMapping(path = "/api/v1/deleteStudentLesson")
    public ResponseEntity deleteStudentLesson(@RequestBody StudentLessonsSaveRequestDto studentLessonsSaveRequestDto){

        studentLessonsService.delete(studentLessonsSaveRequestDto);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PostMapping(path = "/api/v1/getAllStudentsByIdLesson")
    public ResponseEntity getAllStudentsByIdLesson(@RequestBody StudentRequestDto studentRequestDto){

        Long id_lessons = studentRequestDto.getId_lessons();
        List<Students> allStudentsByIdLesson = studentLessonsService.findAllStudentsByIdLesson(id_lessons);

        return ResponseEntity.ok(RestResponse.of(allStudentsByIdLesson));
    }

}
