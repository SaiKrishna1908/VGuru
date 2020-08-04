package com.Vguru.Service.Controller;

import com.Vguru.Service.GuruService.CourseService;
import com.Vguru.Service.GuruService.LectureService;
import com.Vguru.Service.GuruService.StudentService;
import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.ListCourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/student")
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class StudentController {

    private final CourseService courseService;
    private  final StudentService studentService;
    private final LectureService lectureService;


    @GetMapping("/username/{username}")
    public ResponseEntity<?> getStudentByUsername(@PathVariable String username){

        StudentDTO studentDTO = studentService.findByUsername(username);
        if(studentDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return ResponseEntity.ok(studentDTO);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id,@RequestParam String username ){
        StudentDTO studentDTO =  studentService.findByUsername(username);
        if(studentDTO == null)
                return new ResponseEntity(HttpStatus.NOT_FOUND);

        if(!studentDTO.getUsername().equals(username))
            return new ResponseEntity<>("Not Authorized", HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(studentDTO);
    }



    @GetMapping("/{id}/courses")
    public ResponseEntity<?> getStudentCourses(@PathVariable Long id, @RequestParam("username") String username){
        StudentDTO studentDTO = studentService.findById(id);
        if(!studentDTO.getUsername().equals(username))
            return new ResponseEntity<>("Not Authorized", HttpStatus.BAD_REQUEST);
        List<CourseDTO> courses = studentService.findCoursesByIdAndUsername(id, username);
        return  ResponseEntity.ok(courses);
    }



}
