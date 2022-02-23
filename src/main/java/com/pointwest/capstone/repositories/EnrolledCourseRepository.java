package com.pointwest.capstone.repositories;

import com.pointwest.capstone.models.EnrolledCourse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnrolledCourseRepository extends CrudRepository<EnrolledCourse, Object> {
}
