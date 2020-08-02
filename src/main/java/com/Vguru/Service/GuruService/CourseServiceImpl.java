package com.Vguru.Service.GuruService;

import com.Vguru.Service.Repos.CourseRepo;
import com.Vguru.Service.Repos.LectureRepo;
import com.Vguru.Service.Repos.StudentRepo;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService{

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final LectureRepo lectureRepo;


    @Override
        public List<Course> getCourseByStandard(Integer standard) {
            return courseRepo.getCourseByStandard(standard);
    }
}
