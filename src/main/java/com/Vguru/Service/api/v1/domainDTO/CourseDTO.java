package com.Vguru.Service.api.v1.domainDTO;

import com.Vguru.Service.model.Lecture;
import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

import javax.persistence.Entity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Setter
@Getter
public class CourseDTO {

    private Long id;
    private String name;
    private Integer standard;
    private Set<LectureDTO> lectures = new HashSet<>();

}
