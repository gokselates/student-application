package com.app.studentapplication.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTSLESSONS")
@Getter
@Setter
public class StudentsLessons {

    @Id
    @SequenceGenerator(name = "GENERATOR_STUDENTS_ID_SEQ", sequenceName = "STUDENTS_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "GENERATOR_STUDENTS_ID_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private Long id_students;

    @Column
    private Long id_lessons;
}
