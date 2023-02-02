package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);

    public List<Student> findByFistNameAndLastNameContaining(String firstName, String lastName);
}
