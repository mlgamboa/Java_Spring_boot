package com.pointwest.capstone.services;

import com.pointwest.capstone.models.Course;
import com.pointwest.capstone.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    public void createCourse(Course course){
        courseRepository.save(course);
    }
}
