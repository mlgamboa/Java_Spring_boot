package com.pointwest.capstone.models;

import javax.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String courseName;
    @Column
    private String courseCode;
    @Column
    private boolean isAvailable;
    @Column
    private boolean isFull;

    public Course() {
    }

    public Course(String courseName, String courseCode, boolean isAvailable, boolean isFull) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.isAvailable = isAvailable;
        this.isFull = isFull;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }
}
