package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Guardian;
import com.bilal.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Guardian guardian = Guardian.builder()
                .email("guardian@gmail.com")
                .name("guardianOB")
                .mobile("0636666666")
                .build();

        Student student = Student.builder()
                .firstName("bilal")
                .lastName("oumehdi")
                .emailId("bilal@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void  printAllStudents() {
        List<Student> studentsList = studentRepository.findAll();
        System.out.println("studentList = "+ studentsList);
    }

    @Test
    public void printStudentByFirstNameAndLastName(){
        List<Student> studentsList = studentRepository.findByFirstNameAndLastName("bilal" ,"oumehdi");

        System.out.println("students +" + studentsList);
    }
   @Test
    public void printStudentByLastNameContaining() {
        List<Student> studentsList = studentRepository.findByLastNameContaining("oum");

        System.out.println("Students list = " + studentsList);
    }

    @Test
    public void printStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("bilal@gmail.com");

        System.out.println("Students : "+ student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress(){
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("bilal@gmail.com");
        System.out.println("Student first Name : "+firstName);
    }

    @Test
    public void printStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentFirstNameByEmailAddressNative("bilal@gmail.com");
        System.out.println("Student first Name : "+student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentFirstNameByEmailAddressNativeNamedParam("bilal@gmail.com");
        System.out.println("student : " +student);
    }
    @Test
    public void updateStudentFirstNameByEmailAddressTest(){
        studentRepository.updateStudentFirstNameByEmailAddress("Bilal","bilal@gmail.com");
    }


}