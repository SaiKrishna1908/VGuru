package com.Vguru.Service.bootstrap;

import com.Vguru.Service.Repos.CourseRepo;
import com.Vguru.Service.Repos.LectureRepo;
import com.Vguru.Service.Repos.StudentRepo;
import com.Vguru.Service.model.Course;
import com.Vguru.Service.model.Lecture;
import com.Vguru.Service.model.Student;
import com.Vguru.Service.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
@RequiredArgsConstructor
public class dataloader implements CommandLineRunner {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;
    private final LectureRepo lectureRepo;

    @Override
    public void run(String... args) throws Exception {
//        loadCourses();
    loadData();
    }

    private void loadCourses(){

//        Student chaitu = new Student();
//
//        chaitu.setUsername("lazytitan");
//        chaitu.setPassword("cadbury5");
//        chaitu.setStandard(1);
//
//        chaitu= studentRepo.save(chaitu);
//
//        Student sai = new Student();
//
//        sai.setUsername("Krishna1908");
//        sai.setPassword("greatdane");
//        sai.setStandard(2);
//
//
//
//        Course math = new Course();
//        Lecture intro = new Lecture();
//        intro.setName("Name");
//
//        intro.setUrl("www.pornhub.com");
//
//        Lecture end = new Lecture();
//        end.setName("end");
//        end.setUrl("www.brazzers.com");
//        Lecture savedInto =  lectureRepo.save(intro);
//         Lecture savedEnd = lectureRepo.save(end);
//
//        math.setName("Math");
//        math.setStandard(1);
//        math.getStudents().add(chaitu);
//        math.getLectures().add(savedInto);
//        math.getLectures().add(savedEnd);
//        chaitu.getCourses().add(courseRepo.save(math));
//
//        Course science = new Course();
//
//        science.setName("Science");
//        science.getStudents().add(chaitu);
//        science.setStandard(1);
//        chaitu.getCourses().add(courseRepo.save(science));
//
//
//        Course social = new Course();
//
//        social.setName("Social");
//        social.getStudents().add(chaitu);
//        social.setStandard(1);
//        chaitu.getCourses().add(courseRepo.save(social));
//        studentRepo.save(chaitu);
//
//        Course algebra = new Course();
//        algebra.setName("Algebra");
//        algebra.setStandard(2);
//
//        courseRepo.save(algebra);
//
//        Course geometry = new Course();
////        math.setId(1L);
////        geometry.getLectures().add("ml.com");
////        geometry.getLectures().add("io.com");
////        geometry.getLectures().add("com");
//        geometry.setName("geometry");
//        geometry.setStandard(2);
//
//        courseRepo.save(geometry);
//
//
//        Course physics = new Course();
////        math.setId(1L);
////        physics.getLectures().add("ml.com");
////        physics.getLectures().add("io.com");
////        physics.getLectures().add("com");
//        physics.setName("physics");
//        physics.setStandard(2);
//
//        courseRepo.save(physics);
//
//        chaitu.getCourses().add(math);
//        chaitu.getCourses().add(science);
//        chaitu.getCourses().add(social);
//

    }

    private void loadData(){

        Student sai = new Student();
        sai.setEmail("Email.com");
        sai.setStandard(1);
        sai.setUsername("sai1908");
        sai.setPassword("12345");
        sai = studentRepo.save(sai);

        Student chaitu = new Student();
        chaitu.setStandard(5);
        chaitu.setEmail("chaitu1866.com");
        chaitu.setUsername("chaitu1866");
        chaitu.setPassword("09877");
        chaitu.setIsAdmin(true);
        chaitu = studentRepo.save(chaitu);

        Student ram = new Student();
        ram.setStandard(5);
        ram.setEmail("ram1908.com");
        ram.setUsername("lazytitan");
        ram.setPassword("qewey");
        ram = studentRepo.save(ram);

        Student raju = new Student();
        raju.setUsername("geralt");
        raju.setPassword("rivia");
        raju.setStandard(10);
        raju.setEmail("warframe.com");
        raju = studentRepo.save(raju);

        Student qwerty = new Student();
        qwerty.setEmail("qwerty@email.com");
        qwerty.setUsername("ajcky");
        qwerty.setPassword("password");
        qwerty.setStandard(10);

        // courses and Lectures

        Course math  = new Course();
        math.setName("Mathematics");
        math.setStandard(1);
        courseRepo.save(math);

        Lecture lecture = new Lecture();
        lecture.setUrl("www.abcd.com");
        lecture.setName("Math 101");
        lecture.setCourses(math);
        math.addLecture(lectureRepo.save(lecture));

        math.addStudent(chaitu);

        courseRepo.save(math);

        Course science = new Course();
        science.setName("Science");
        science.setStandard(1);
        courseRepo.save(science);

        Lecture lecture1 = new Lecture();
        lecture1.setUrl("www.bcde.com");
        lecture1.setName("Math 201");
        lecture1.setCourses(science);

        Lecture lecture3 = new Lecture();
        lecture3.setUrl("www.bcdef.com");
        lecture3.setName("Math 301");
        lecture3.setCourses(science);

        science.addLecture(lectureRepo.save(lecture3));
        science.addLecture(lectureRepo.save(lecture1));
        courseRepo.save(science.addStudent(chaitu));

        studentRepo.save(chaitu);

        // Social
        Course social = new Course();
        social.setName("Social");
        social.setStandard(5);
        courseRepo.save(social);

        Lecture lecture2 = new Lecture();
        lecture2.setUrl("bcd.com");
        lecture2.setCourses(social);
        social.addLecture(lectureRepo.save(lecture2));
        courseRepo.save(social.addStudent(ram));

        studentRepo.save(ram);

        //Economics
        Course eco = new Course();
        eco.setName("Economics");
        eco.setStandard(10);
        courseRepo.save(eco);

        Lecture ecolec = new Lecture();
        ecolec.setUrl("Youtube.com");
        ecolec.setCourses(eco);
        eco.addLecture(lectureRepo.save(ecolec));
        courseRepo.save(eco.addStudent(raju));

        studentRepo.save(raju);

    }
}
