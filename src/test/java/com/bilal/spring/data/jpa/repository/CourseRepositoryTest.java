package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Course;
import com.bilal.spring.data.jpa.entity.Student;
import com.bilal.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printAllCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses : "+ courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Toumi")
                .lastName("bouchentouf")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void printCoursesWithPagination (){
        Pageable firstPageOfTwoRecords = PageRequest.of(0,2);

        Pageable secondPageOfThreeRecords = PageRequest.of(1,3);

        List<Course> courses = courseRepository.findAll(firstPageOfTwoRecords).getContent();

        long totalElements = courseRepository.findAll(firstPageOfTwoRecords).getTotalElements();
        System.out.println("total elements: "+totalElements);

        long totalPages = courseRepository.findAll(firstPageOfTwoRecords).getTotalPages();
        System.out.println("total pages: "+totalPages);

        System.out.println("coureses : "+courses);
    }
    @Test
    public void printCoursesWithSorting(){

        List<Course> coursesByTitle = courseRepository.findAll(
                Sort.by("title"));

        List<Course> coursesByCreditAndTitleDescending = courseRepository.findAll(
                Sort.by("credit").descending().and(Sort.by("title")));

        System.out.println("Courses sorted by title: "+coursesByTitle);
        System.out.println("Courses sorted by credit and title descending: "+coursesByCreditAndTitleDescending);
    }


    @Test
    public void saveCourseWithStudentsAndTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("ihab")
                .lastName("Annaki")
                .build();
        Student student = Student.builder()
                .firstName("mohammed")
                .lastName("oumehdi")
                .emailId("mohammed48@gmail.com")
                .build();

        Course course = Course.builder()
                .title("JavaScript")
                .credit(7)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}