package com.Vguru.Service.model;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "courses", fetch = FetchType.EAGER)
    private Set<Lecture> lectures= new HashSet<>();

    private Integer standard;

    @ManyToMany(mappedBy = "courses")
    Set<Student> students = new HashSet<>();

    public Course addLecture(Lecture lecture){
        this.getLectures().add(lecture);
        lecture.setCourses(this);
        return this;
    }

    public Course addStudent(Student student){
        this.getStudents().add(student);
        student.getCourses().add(this);

        return this;
    }
}
