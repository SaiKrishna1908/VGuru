package com.Vguru.Service.Controller;

import com.Vguru.Service.GuruService.CourseService;
import com.Vguru.Service.GuruService.LectureService;
import com.Vguru.Service.GuruService.StudentService;
import com.Vguru.Service.api.v1.domainDTO.ListCourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class StudentController {

    private final CourseService courseService;
    private  final StudentService studentService;
    private final LectureService lectureService;


    //TODO: get email from Request Param's
    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable Long id){

        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        StudentDTO studentDTO =  studentService.findById(id);
        if(studentDTO == null)
                return new StudentDTO();
        return studentDTO;
    }

    @GetMapping("/{id}/courses")
    public ListCourseDTO getStudentCourses(@PathVariable Long id){
        return  new ListCourseDTO(studentService.findCourses(id));
    }



}
