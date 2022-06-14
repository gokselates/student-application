package com.app.studentapplication.repository;

import com.app.studentapplication.entity.Lessons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lessons,Long> {
}
