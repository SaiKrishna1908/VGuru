package com.Vguru.Service.api.v1.domainDTO;

import com.Vguru.Service.model.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;


@Getter
@Setter
public class LectureDTO {

    private Long id;
    private String name;
    private String url;

//    private CourseDTO courseDTO;
}
