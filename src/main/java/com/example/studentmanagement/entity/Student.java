package com.example.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_code", unique = true, nullable = false, length = 50)
    private String studentCode; // mã sinh viên

    @Column(name = "full_name", nullable = false, length = 100)
    private String fullName; // tên sinh viên

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth; // ngày sinh

    @Column(name = "gender", length = 10)
    private String gender; // giới tính

    @Column(name = "phone_number", length = 15)
    private String phoneNumber; // sđt

    @Column(name = "gpa")
    private Double gpa; // GPA
}
