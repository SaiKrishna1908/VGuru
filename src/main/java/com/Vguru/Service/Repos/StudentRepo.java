package com.Vguru.Service.Repos;


import com.Vguru.Service.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Long> {

}