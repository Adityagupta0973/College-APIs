package com.example.demo1.service.impl;

import com.example.demo1.model.Course;
import com.example.demo1.repository.CourseRepository;
import com.example.demo1.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public String createCourse(Course course) {
        courseRepository.save(course);
        return "Course Created Successfully";
    }

    @Override
    public String updateCourse(Course course) {
        courseRepository.save(course);
        return "Course Updated Successfully";
    }

    @Override
    public String deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
        return "Course Deleted Successfully";
    }

    @Override
    public Course getCourse(Long collegeId) {
        return null;
    }

    @Override
    public List<Course> getCoursesByCollegeId(Long collegeId) {
        return courseRepository.findByCollegeId(collegeId);
    }

    @Override
    public List<Course> getAllCourses() {return courseRepository.findAll();}
}
