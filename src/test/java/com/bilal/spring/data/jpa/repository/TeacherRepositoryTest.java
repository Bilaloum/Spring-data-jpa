package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Course;
import com.bilal.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository ;

    @Test
    public void saveTeacher(){

            Course course = Course.builder()
                    .title("C#")
                    .credit(4)
                    .build();
        Teacher teacher = Teacher.builder()
                .firstName("jamal")
                .lastName("naimi")
                //.courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }
    @Test
    public void printTeacher(){

    }
}