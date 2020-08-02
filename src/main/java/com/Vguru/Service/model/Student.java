package com.Vguru.Service.model;

import com.Vguru.Service.Repos.CourseRepo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//todo : courses
@Getter
@Setter
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private Integer standard;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Student_Courses",
            joinColumns={@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses = new HashSet<>();


}
