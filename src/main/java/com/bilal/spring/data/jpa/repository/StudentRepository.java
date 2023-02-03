package com.bilal.spring.data.jpa.repository;

import com.bilal.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public List<Student> findByFirstNameAndLastName(String firstName,String lastName);

    public List<Student> findByLastNameContaining(String lastName);

    public List<Student> findByFirstNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    //JPQL --> based on classes name and properties

    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);




    // JPQL--> get the firstName based on email address
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String firstName);

    // NativeQuery
    @Query(
            value = "SELECT * from student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentFirstNameByEmailAddressNative(String firstName);

    // Native query Named params
    @Query(
            value = "SELECT * from student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentFirstNameByEmailAddressNativeNamedParam(@Param("emailId") String firstName);


    //for transactional queries
    @Modifying
    @Transactional
    @Query(
            value = "update student set first_name= ?1 where email_address= ?2",
            nativeQuery = true
    )
    int updateStudentFirstNameByEmailAddress(String firstName,String emailId);


}
