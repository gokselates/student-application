package com.app.studentapplication.service;

import com.app.studentapplication.converter.LessonsConverter;
import com.app.studentapplication.dto.LessonsSaveRequestDto;
import com.app.studentapplication.dto.StudentLessonsSaveRequestDto;
import com.app.studentapplication.entity.Lessons;
import com.app.studentapplication.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonsService {

    private final LessonRepository lessonRepository;
    private final LessonsConverter lessonsConverter;

    private Lessons lessons;

    public List<Lessons> getAllLessons()
    {
        List<Lessons> lessons = new ArrayList<Lessons>();
        lessonRepository.findAll().forEach(student -> lessons.add(student));
        return lessons;
    }

    public Long getLessonQuota(StudentLessonsSaveRequestDto studentLessonsSaveRequestDto){
        Lessons lessons = lessonRepository.findById(studentLessonsSaveRequestDto.getId_lessons()).get();
        return lessons.getQuota();
    }

    public Lessons save(LessonsSaveRequestDto lessonsSaveRequestDto) {
        lessons = lessonsConverter.convertToLessons(lessonsSaveRequestDto);
        lessons = lessonRepository.save(lessons);
        return lessons;
    }

    public Lessons update(LessonsSaveRequestDto lessonsSaveRequestDto) {
        lessons = findById(lessonsSaveRequestDto.getId());
        lessons.setName(lessonsSaveRequestDto.getName());
        lessons.setQuota(lessonsSaveRequestDto.getQuota());
        lessons = lessonRepository.save(lessons);
        return lessons;
    }



    public Lessons findById(Long id){
        return lessonRepository.findById(id).get();
    }
}
