package com.app.studentapplication.converter;

import com.app.studentapplication.dto.LessonsSaveRequestDto;
import com.app.studentapplication.entity.Lessons;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonsConverter {


    public Lessons convertToLessons(LessonsSaveRequestDto lessonsSaveRequestDto){
        Lessons lessons = new Lessons();
        lessons.setName(lessonsSaveRequestDto.getName());
        lessons.setQuota(lessonsSaveRequestDto.getQuota());
        return lessons;
    }
}
