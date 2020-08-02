package com.Vguru.Service.GuruService;

import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Student;

import java.util.List;

public interface StudentService {

    StudentDTO findById(Long id);
    List<CourseDTO> findCourses(Long id);
}
