package com.Vguru.Service.api.v1.domainDTO;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
public class CourseDTO {

    private Long id;
    private String name;
//    private Set<LectureDTO> lectureDTOS = new HashSet<>();
    private Integer standard;
//    private Set<StudentDTO> studentDTOS = new HashSet<>();
}
