package com.app.studentapplication.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTSLESSONS")
public class StudentsLessons {

    @Id
    @SequenceGenerator(name = "GENERATOR_STUDENTS_ID_SEQ", sequenceName = "STUDENTS_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "GENERATOR_STUDENTS_ID_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Long id_students;

    @Column
    private Long id_lessons;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_students() {
        return id_students;
    }

    public void setId_students(Long id_students) {
        this.id_students = id_students;
    }

    public Long getId_lessons() {
        return id_lessons;
    }

    public void setId_lessons(Long id_lessons) {
        this.id_lessons = id_lessons;
    }
}
