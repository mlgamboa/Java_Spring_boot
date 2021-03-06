package com.pointwest.capstone.repositories;

import com.pointwest.capstone.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Object> {
    Course findByCourseName(String courseName);
}
