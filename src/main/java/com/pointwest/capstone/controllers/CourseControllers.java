package com.pointwest.capstone.controllers;

import com.pointwest.capstone.models.Course;
import com.pointwest.capstone.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CourseControllers {

    @Autowired
    CourseService courseService;

    // Create a course
    @RequestMapping(value = "/courses", method = RequestMethod.POST)
    public ResponseEntity<Object> createCourse (@RequestBody Course course){
        courseService.createCourse(course);
        return new ResponseEntity<>("Created a course", HttpStatus.CREATED);
    }
}
