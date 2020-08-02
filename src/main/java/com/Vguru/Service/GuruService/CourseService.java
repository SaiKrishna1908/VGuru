package com.Vguru.Service.GuruService;

import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.LectureDTO;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;

import java.util.List;

public interface CourseService  {

    List<CourseDTO> getAllCourses();
    List<CourseDTO> getCourseByStandard(Integer standard);
    List<LectureDTO> getCourseLectures(Long id);
}
