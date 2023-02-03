package com.bilal.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "course_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long courseId ;
    private String title;
    private Integer credit ;

    @OneToOne(
            mappedBy = "course",
            optional = false
    )
    private CourseMaterial courseMaterial ;
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "students_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students == null) students = new ArrayList<>();

        students.add(student);
    }
}
