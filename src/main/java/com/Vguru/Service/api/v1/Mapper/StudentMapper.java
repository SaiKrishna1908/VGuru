package com.Vguru.Service.api.v1.Mapper;

import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {

    static StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    StudentDTO studentToStudentDTO(Student student);
}
