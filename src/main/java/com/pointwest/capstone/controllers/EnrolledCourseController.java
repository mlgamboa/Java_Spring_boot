package com.pointwest.capstone.controllers;

import com.pointwest.capstone.models.EnrolledCourse;
import com.pointwest.capstone.services.EnrolledCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class EnrolledCourseController {

    @Autowired
    EnrolledCourseService enrolledCourseService;

    @RequestMapping(value = "/enroll", method = RequestMethod.POST)
    public ResponseEntity<Object> enrollStudent(@RequestBody Map<String, String> body){
        String username = body.get("username");
        String coursename = body.get("courseName");
        return enrolledCourseService.enrollStudent(username, coursename);
    }
}
