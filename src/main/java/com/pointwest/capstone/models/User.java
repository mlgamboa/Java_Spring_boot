package com.pointwest.capstone.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phoneNumber;

    @OneToMany(mappedBy = "user")
    private Set<EnrolledCourse> enrolledCourses;

    public User() {
    }


    public User(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

//    public Set<EnrolledCourse> getEnrolledCourses() {
//        return enrolledCourses;
//    }

//    public void setEnrolledCourses(Set<EnrolledCourse> enrolledCourses) {
//        this.enrolledCourses = enrolledCourses;
//    }
}
