package com.pointwest.capstone.services;

import com.pointwest.capstone.config.JwtToken;
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

import java.util.Optional;
import java.util.Set;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    JwtToken jwtToken;
    @Autowired
    private EnrolledCourseRepository enrolledCourseRepository;

    public ResponseEntity createCourse(Course course){
        String message = "Course Successfully Added";
        HttpStatus status = HttpStatus.CREATED;
        boolean isDuplicate = false;

        if(course.isAvailable()) {

            for (Course allCourses : courseRepository.findAll()) {
                if (course.getCourseCode().equalsIgnoreCase(allCourses.getCourseCode())) {
                    message = "Course already exists";
                    status = HttpStatus.CONFLICT;
                    isDuplicate = true;
                }
            }
            if (!isDuplicate) {
                Course newCourse = new Course();
                newCourse.setCourseName(course.getCourseName());
                newCourse.setCourseCode(course.getCourseCode());
                newCourse.setAvailable(course.isAvailable());
                newCourse.setFull(course.isFull());
                courseRepository.save(newCourse);
            }
        } else {
            String unavailability = "Course is not available. Please choose another";
        }
        return new ResponseEntity(message, status);
    }

    // Get all courses
    public Iterable<Course> getAllCourse(){
       return courseRepository.findAll();
    }


    // Updating a course
    public ResponseEntity updateCourse(Long id, Course course){
        Course courseForUpdating = courseRepository.findById(id).get();
        courseForUpdating.setCourseCode(course.getCourseCode());
        courseForUpdating.setCourseName(course.getCourseName());
        courseForUpdating.setAvailable(course.isAvailable());
        courseForUpdating.setFull(course.isFull());
        return new ResponseEntity("Course updated successfully", HttpStatus.OK);
    }


    // Archiving courses that are full
    public ResponseEntity archiveCourse(Long id){
        Course courseForArchive = courseRepository.findById(id).get();
        courseForArchive.setFull(!courseForArchive.isFull());
        courseRepository.save(courseForArchive);
        return new ResponseEntity("Course 'Full' status was update to: "+ courseForArchive.isFull(), HttpStatus.OK);
    }


    // Retrieving specific course
    public ResponseEntity getSpecificCourse(Long id){
        Course courseToFind = courseRepository.findById(id).get();
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }

    // Retrieving user's courses
//    public Set<EnrolledCourse> getMyCourses(String stringToken){
//        User student = userRepository.findByUsername(jwtToken.getUsernameFromToken(stringToken));
//        return student.getEnrolledCourses();
//    }

    public Optional<Course> findByCourseName(String courseName){
      return Optional.ofNullable(courseRepository.findByCourseName(courseName));
    }
}
