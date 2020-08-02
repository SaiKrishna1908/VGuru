package com.Vguru.Service.Repos;

import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    List<Course> getCourseByStandard(Integer standard);

}
