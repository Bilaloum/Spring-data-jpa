package com.bilal.spring.data.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

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
            mappedBy = "course"
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

}
