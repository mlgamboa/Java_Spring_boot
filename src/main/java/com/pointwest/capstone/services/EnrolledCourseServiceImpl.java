package com.pointwest.capstone.services;

import com.pointwest.capstone.models.Course;
import com.pointwest.capstone.models.EnrolledCourse;
import com.pointwest.capstone.models.User;
import com.pointwest.capstone.repositories.CourseRepository;
import com.pointwest.capstone.repositories.EnrolledCourseRepository;
import com.pointwest.capstone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrolledCourseServiceImpl implements EnrolledCourseService{

    @Autowired
    EnrolledCourseRepository enrolledCourseRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CourseRepository courseRepository;

    public ResponseEntity enrollStudent(String username, String coursename){
        String message = "Student enrolled successfully";
        HttpStatus status = HttpStatus.CREATED;
        boolean isEnrolled = false;

        for (EnrolledCourse enrollee : enrolledCourseRepository.findAll()){
            if(username.equals(enrollee.getUser().getUsername()) && coursename.equals(enrollee.getCourse().getCourseName())){
                message = "Student is already enrolled in that course";
                status = HttpStatus.CONFLICT;
                isEnrolled = true;
            }
        }
        if(!isEnrolled){
            User user = userRepository.findByUsername(username);
            Course course = courseRepository.findByCourseName(coursename);
            EnrolledCourse newEnrollee = new EnrolledCourse();
            newEnrollee.setUser(user);
            newEnrollee.setCourse(course);
            enrolledCourseRepository.save(newEnrollee);
        }
        return new ResponseEntity(message, status);
    }

}
