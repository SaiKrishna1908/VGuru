package com.Vguru.Service.GuruService;

import com.Vguru.Service.Repos.CourseRepo;
import com.Vguru.Service.Repos.LectureRepo;
import com.Vguru.Service.Repos.StudentRepo;
import com.Vguru.Service.api.v1.Mapper.CourseMapper;
import com.Vguru.Service.api.v1.Mapper.StudentMapper;
import com.Vguru.Service.api.v1.domainDTO.CourseDTO;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import com.Vguru.Service.model.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class StudentServiceImpl implements StudentService, UserDetailsService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final LectureRepo lectureRepo;

    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

    @Override
    public StudentDTO findById(Long id) {
        Optional<Student> studentOptional = studentRepo.findStudentById(id);

        return studentOptional.map(studentMapper::studentToStudentDTO).orElse(null);
    }

    @Override
    public List<CourseDTO> findCourses(Long id) {
        Optional<Student> studentOptional = studentRepo.findStudentById(id);

        if (!studentOptional.isPresent()) {
            log.debug("No student found");
            return null;
        } else {
            Integer standard = studentOptional.get().getStandard();
            List<CourseDTO> courseDTOS = courseRepo.getCourseByStandard(standard).stream()
                    .map(courseMapper::courseToCourseDTO).collect(Collectors.toList());
            return courseDTOS;
        }

    }

    @Override
    public Student findByUsername(String username) {
        if(username != null)
            return studentRepo.findStudentByUsername(username);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Student student = studentRepo.findStudentByUsername(username);
        return new User(student.getUsername(), student.getPassword(),null);
    }
}
