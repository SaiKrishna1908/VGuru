package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentDTOMapper {
    static final StudentDTOMapper INSTANCE = Mappers.getMapper(StudentDTOMapper.class);

    Student studentDTOToStudent(StudentDTO studentDTO);
}
