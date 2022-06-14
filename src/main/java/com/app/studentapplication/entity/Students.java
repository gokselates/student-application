package com.app.studentapplication.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "STUDENTS")
public class Students {

    @Id
    @SequenceGenerator(name = "GENERATOR_STUDENTS_ID_SEQ", sequenceName = "STUDENTS_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "GENERATOR_STUDENTS_ID_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Lob
    @Column(length=100000)
    private byte[] studentImage;

    @ManyToMany
    @JoinTable(
            name = "STUDENTSLESSONS",
            joinColumns = @JoinColumn(name = "id_students"),
            inverseJoinColumns = @JoinColumn(name = "id_lessons"))
            private Set<Lessons> lessonsSet;

    public void Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public byte[] getStudentImage() {
        return studentImage;
    }

    public void setStudentImage(byte[] studentImage) {
        this.studentImage = studentImage;
    }
}
