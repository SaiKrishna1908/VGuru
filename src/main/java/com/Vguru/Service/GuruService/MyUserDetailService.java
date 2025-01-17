package com.Vguru.Service.GuruService;

import com.Vguru.Service.api.v1.Mapper.StudentDTOMapper;
import com.Vguru.Service.api.v1.Mapper.StudentMapper;
import com.Vguru.Service.api.v1.domainDTO.StudentDTO;
import com.Vguru.Service.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired StudentService studentService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Student student = studentService.findStudentByUsername(s);
        return new User(student.getUsername(), student.getPassword(), new ArrayList<>());
    }
}
