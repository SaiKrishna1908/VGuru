package com.Vguru.Service.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Lecture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "CourseId", referencedColumnName = "id")
    private Course courses;

}
