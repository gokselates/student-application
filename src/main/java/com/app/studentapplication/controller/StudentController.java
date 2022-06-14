package com.app.studentapplication.controller;

import com.app.studentapplication.dto.StudentsSaveRequestDto;
import com.app.studentapplication.entity.Students;
import com.app.studentapplication.response.RestResponse;
import com.app.studentapplication.service.StudentsService;
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
public class StudentController {

    private final StudentsService studentsService;

    @GetMapping("/api/v1/getAllStudent")
    private List<Students> getAllStudent()
    {
        return studentsService.getAllStudent();
    }

    @PostMapping(path = "/api/v1/addStudent")
    public ResponseEntity addStudent(@RequestBody StudentsSaveRequestDto studentsSaveRequestDto){

        Students students = studentsService.save(studentsSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(students));
    }

    @PostMapping(path = "/api/v1/updateStudent")
    public ResponseEntity updateStudent(@RequestBody StudentsSaveRequestDto studentsSaveRequestDto){

        Students students = studentsService.update(studentsSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(students));
    }

}
