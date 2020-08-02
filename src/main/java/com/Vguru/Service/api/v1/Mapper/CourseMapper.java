package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourseMapper  {

    static final  CourseMapper INSTANCE = Mappers.getMapper(CourseMapper.class);

    CourseDTO courseToCourseDTO(Course course);
}
