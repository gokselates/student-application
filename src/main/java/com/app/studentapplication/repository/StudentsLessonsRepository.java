package com.app.studentapplication.repository;

import com.app.studentapplication.entity.Students;
import com.app.studentapplication.entity.StudentsLessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface StudentsLessonsRepository extends JpaRepository<StudentsLessons,Long> {

    @Modifying
    @Query("delete from StudentsLessons s where s.id_lessons =:id_lessons and s.id_students =:id_students")
    void deleteStudentsLessonsByIdLessonsAndIdStudents(@Param("id_lessons") Long id_lessons, @Param("id_students") Long id_students);

    @Query("select count(s) from StudentsLessons s where s.id_lessons =:id_lessons")
    public Long findAllStudentsCountByIdLesson(@Param("id_lessons") Long id_lessons);

    @Query("select s from StudentsLessons sl,Students s where s.id = sl.id_students and sl.id_lessons =:id_lessons")
    public List<Students> findAllStudentsByIdLesson(@Param("id_lessons") Long id_lessons);
}
