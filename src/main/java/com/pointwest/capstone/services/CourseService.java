package com.pointwest.capstone.services;

import com.pointwest.capstone.models.Course;
import com.pointwest.capstone.models.EnrolledCourse;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Set;

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
    ResponseEntity getSpecificCourse(Long id);

//    Set<EnrolledCourse> getMyCourses(String stringToken);

    Optional<Course> findByCourseName(String CourseName);

}
