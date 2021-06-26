package com.crud.crud.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "student")
@Data
@Builder
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private int id;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "student_roll", nullable = false, unique = true)
    private String studentRoll;
}
