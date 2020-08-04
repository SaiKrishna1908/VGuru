package com.Vguru.Service.GuruService;

import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Student;
import com.Vguru.Service.model.UserInfo;

import java.util.List;

public interface StudentService {

    StudentDTO findById(Long id);
    List<CourseDTO> findCoursesByIdAndUsername(Long id, String username);
    Student findStudentByUsername(String username);

    StudentDTO findByUsername(String username);
}
