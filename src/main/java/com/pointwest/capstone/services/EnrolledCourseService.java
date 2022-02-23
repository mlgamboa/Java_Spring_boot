package com.pointwest.capstone.services;


import com.pointwest.capstone.models.EnrolledCourse;
import org.springframework.http.ResponseEntity;

public interface EnrolledCourseService {

    ResponseEntity enrollStudent(String username, String coursename);
}
