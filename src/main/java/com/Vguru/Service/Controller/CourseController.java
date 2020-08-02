package com.Vguru.Service.Controller;


import com.Vguru.Service.GuruService.CourseService;
import com.Vguru.Service.GuruService.LectureService;
import com.Vguru.Service.GuruService.StudentService;
import com.Vguru.Service.api.v1.domainDTO.LectureDTO;
import com.Vguru.Service.api.v1.domainDTO.ListCourseDTO;
import com.Vguru.Service.api.v1.domainDTO.ListLectureDTO;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final LectureService lectureService;
    private  final StudentService studentService;

    @GetMapping(value = "/courses")
    ListCourseDTO getAllCourses(){
        return new ListCourseDTO(courseService.getAllCourses());
    }

    //TODO: Move it into lecture controller
    @GetMapping(value = "/{courseId}/lectures")
    ListLectureDTO getCourseLectures(@PathVariable Long courseId){
        List<LectureDTO> lectureDTOS = courseService.getCourseLectures(courseId);
        System.out.println(lectureDTOS.size());
        return new ListLectureDTO(lectureDTOS);
    }
}
