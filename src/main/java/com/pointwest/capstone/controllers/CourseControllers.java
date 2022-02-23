package com.pointwest.capstone.controllers;

import com.pointwest.capstone.models.Course;
import com.pointwest.capstone.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CourseControllers {

    @Autowired
    CourseService courseService;

    // Create/Add a course
    @RequestMapping(value = "/courses/add", method = RequestMethod.POST)
    public ResponseEntity<Object> createCourse (@RequestBody Course course){
        return courseService.createCourse(course);
    }

    // Get all course
    @RequestMapping(value = "/courses/get", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllCourse (){
        return new ResponseEntity<>(courseService.getAllCourse(),HttpStatus.OK);
    }

    // Updating a course
    @RequestMapping(value = "/courses/update/{courseId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCourse(@PathVariable Long courseId, @RequestBody Course course){
        return courseService.updateCourse(courseId, course);
    }


    // Archiving a course that is full
    @RequestMapping(value = "/courses/archive/{courseId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> archiveCourse(@PathVariable Long courseId){
        return courseService.archiveCourse(courseId);
    }


    // Retrieving specific course
    @RequestMapping(value = "/courses/get/{courseId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getSpecificCourse(@PathVariable Long courseId){
        return courseService.getSpecificCourse(courseId);
    }

    // Retrieve user's courses
//    @RequestMapping(value = "/courses/myCourses", method = RequestMethod.GET)
//    public ResponseEntity<Object> getMyCourses(@RequestHeader(value = "Authorization") String stringToken){
//        return new ResponseEntity<>(courseService.getMyCourses(stringToken), HttpStatus.OK);
//    }
}
