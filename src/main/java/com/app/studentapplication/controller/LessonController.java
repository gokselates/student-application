package com.app.studentapplication.controller;

import com.app.studentapplication.dto.LessonsSaveRequestDto;
import com.app.studentapplication.entity.Lessons;
import com.app.studentapplication.response.RestResponse;
import com.app.studentapplication.service.LessonsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//creating RestController
@RestController
@RequiredArgsConstructor
public class LessonController {

    private final LessonsService lessonsService;

    @GetMapping("/api/v1/getAllLessons")
    private List<Lessons> getAllLessons()
    {
        return lessonsService.getAllLessons();
    }

    @PostMapping(path = "/api/v1/addLesson")
    public ResponseEntity addStudent(@RequestBody LessonsSaveRequestDto lessonsSaveRequestDto){

        Lessons lessons = lessonsService.save(lessonsSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(lessons));
    }

    @PostMapping(path = "/api/v1/updateLesson")
    public ResponseEntity updateStudent(@RequestBody LessonsSaveRequestDto lessonsSaveRequestDto){

        Lessons lessons = lessonsService.update(lessonsSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(lessons));
    }

}
