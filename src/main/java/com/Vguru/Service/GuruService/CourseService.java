package com.Vguru.Service.GuruService;

import com.Vguru.Service.model.Course;

import java.util.List;

public interface CourseService  {

    List<Course> getCourseByStandard(Integer standard);
    
}
