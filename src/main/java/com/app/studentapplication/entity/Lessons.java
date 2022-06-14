package com.app.studentapplication.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "LESSONS")
public class Lessons {

    @Id
    @SequenceGenerator(name = "GENERATOR_LESSONS_ID_SEQ", sequenceName = "LESSONS_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "GENERATOR_LESSONS_ID_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @Column
    private Long quota;

    @ManyToMany(mappedBy = "lessonsSet")
    private Set<Students> students;

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

    public Long getQuota() {
        return quota;
    }

    public void setQuota(Long quota) {
        this.quota = quota;
    }
}
