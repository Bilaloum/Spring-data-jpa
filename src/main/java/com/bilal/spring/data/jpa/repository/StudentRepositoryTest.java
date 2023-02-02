package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Guardian;
import com.bilal.spring.data.jpa.entity.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private  StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Guardian guardian = new Guardian(
                "guardianOB",
                "guardian@gmail.com",
                "0636666666"
        );
        Student student = Student.builder()
                .firstName("bilal")
                .lastName("oumehdi")
                .emailId("bilal@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
}
