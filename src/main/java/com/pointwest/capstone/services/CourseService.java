package com.pointwest.capstone.services;

import com.pointwest.capstone.models.Course;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CourseService {

    // Create/Add a course
    ResponseEntity createCourse(Course course);

    // Retrieve all courses
    Iterable<Course> getAllCourse();

    // Updating a course
    ResponseEntity updateCourse(Long id, Course course);

    // Archiving a course
    ResponseEntity archiveCourse(Long id);

    // Retrieve specific course
//    Optional<Course> findByCourseName(String CourseName);
    ResponseEntity getSpecificCourse(Long id);



}
