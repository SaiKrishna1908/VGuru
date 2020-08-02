package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseDTOMapper {
    static final CourseDTOMapper INSTANCE = Mappers.getMapper(CourseDTOMapper.class);

    Course courseDTOToCourse(CourseDTO courseDTO);
}
