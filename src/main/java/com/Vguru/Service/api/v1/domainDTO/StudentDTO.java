package com.Vguru.Service.api.v1.domainDTO;


import com.Vguru.Service.model.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class StudentDTO {

    private Long id;
    private Integer standard;
    private String username;
//    private Set<Course> courseSet = new HashSet<>();
}
