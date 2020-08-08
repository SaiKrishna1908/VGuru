package com.Vguru.Service.GuruService;

import com.Vguru.Service.Repos.CourseRepo;
import com.Vguru.Service.Repos.LectureRepo;
import com.Vguru.Service.Repos.StudentRepo;
import com.Vguru.Service.api.v1.Mapper.CourseDTOMapper;
import com.Vguru.Service.api.v1.Mapper.CourseMapper;
import com.Vguru.Service.api.v1.Mapper.LectureDTOMapper;
import com.Vguru.Service.api.v1.Mapper.LectureMapper;
import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.LectureDTO;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
@Slf4j
public class CourseServiceImpl implements CourseService{

    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final LectureRepo lectureRepo;

    private final CourseMapper courseMapper;
    private  final LectureMapper lectureMapper;
    private  final CourseDTOMapper courseDTOMapper;
    private  final LectureDTOMapper lectureDTOMapper;

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepo.findAll().stream().map(courseMapper::courseToCourseDTO).collect(Collectors.toList());
    }

    @Override
        public List<CourseDTO> getCourseByStandard(Integer standard) {
            return courseRepo.getCourseByStandard(standard).stream().map(courseMapper::courseToCourseDTO)
                    .collect(Collectors.toList());
    }

    @Override
    public List<LectureDTO> getCourseLectures(Long id) {
        List<Lecture> lectures = lectureRepo.getLecturesByCourses_Id(id);

        return lectures.stream().map(lectureMapper::lectureTOLectureDTO).collect(Collectors.toList());
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        //add all
        Course course = courseDTOMapper.courseDTOToCourse(courseDTO);
        CourseDTO savedCourseDTO = courseMapper.courseToCourseDTO(courseRepo.save(course));
        return savedCourseDTO;
    }

    @Override
    public CourseDTO createLecture(LectureDTO lectureDTO, Long id) {
        Optional<Course> courseOptional = courseRepo.findById(id);

        if(courseOptional.isPresent()){



            Course savedCourse = courseOptional.get();

            //Save Lecture
            Lecture lecture = lectureDTOMapper.LectureDTOToLecture(lectureDTO);
            lecture.setCourses(savedCourse);

            Lecture savedLecture = lectureRepo.save(lecture);
            savedCourse.getLectures().add(savedLecture);

            return courseMapper.courseToCourseDTO(courseRepo.save(savedCourse));
        }

        log.debug("Error saving Lecture");
        return null;
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        Optional<Course> optionalCourse = courseRepo.findById(id);
        if(!optionalCourse.isPresent()) {
            log.debug("No courses found with Id" + id);
            return null;
        }
        return courseMapper.courseToCourseDTO(optionalCourse.get());
    }
}
