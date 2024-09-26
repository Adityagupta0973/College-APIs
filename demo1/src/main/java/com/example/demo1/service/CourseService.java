package com.example.demo1.service;

import com.example.demo1.model.Course;

import java.util.List;

public interface CourseService {
    public String createCourse(Course course);
    public String updateCourse(Course course);
    public String deleteCourse(Long courseId);
    public Course getCourse(Long collegeId);
    public List<Course> getCoursesByCollegeId(Long collegeId);
    public List<Course> getAllCourses();
}
