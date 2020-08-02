package com.Vguru.Service.Controller;

import com.Vguru.Service.GuruService.CourseService;
import com.Vguru.Service.GuruService.LectureService;
import com.Vguru.Service.GuruService.StudentService;
import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
public class StudentController {

    private final CourseService courseService;
    private  final StudentService studentService;
    private final LectureService lectureService;

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){

        StudentDTO studentDTO =  studentService.findById(id);
        if(studentDTO == null)
                return new StudentDTO();
        return studentDTO;
    }

    @GetMapping("/{id}/courses")
    public List<CourseDTO> getStudentCourses(@PathVariable Long id){
        return  studentService.findCourses(id);
    }



}
