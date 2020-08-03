package com.Vguru.Service.model;

import com.Vguru.Service.Repos.CourseRepo;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


//todo : courses
@Getter
@Setter
@Entity
@IdClass(UserInfo.class)
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private Long id;

    @Id
    @Column(name = "email")
    private String email;

    @NotNull
    private String password;
    @NotNull
    private String username;

    private Integer standard;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Student_Courses",
            joinColumns={@JoinColumn(name = "student_id"), @JoinColumn(name = "email")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private Set<Course> courses = new HashSet<>();


}
