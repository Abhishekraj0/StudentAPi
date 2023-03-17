package com.ivoyant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rollNo;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "Last_name")
    private String lastName;
    @Column(name = "father_name")
    private String fatherName;
    @Column(name = "address")
    private String address;
    @Column(name = "dob")
    private String dob;
    @Column(name = "qualification")
    private String qualification;
    @Column(name = "mobile_no")
    private String mobileNo;
    @Column(name = "email_id")
    private String emailId;

}
