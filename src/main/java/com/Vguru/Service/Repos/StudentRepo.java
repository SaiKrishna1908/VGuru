package com.Vguru.Service.Repos;


import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Student;
import com.Vguru.Service.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
        Optional<Student> findStudentById(Long id);
        Student findStudentByUsername(String username);

}
