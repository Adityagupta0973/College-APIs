package com.example.demo1.controller;

import com.example.demo1.model.Course;
import com.example.demo1.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CourseController
{
    CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public List<Course> getAllCourses() {return courseService.getAllCourses();}

    @GetMapping("/college/{collegeId}")
    public List<Course> getCoursesByCollegeId(@PathVariable Long collegeId) {
        return courseService.getCoursesByCollegeId(collegeId);
    }

    @GetMapping("{id}")
    public Course getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    @PostMapping
    public String createCourse(@RequestBody Course course)
    {
        courseService.createCourse(course);
        return "Course Created Successfully";
    }

    @PutMapping
    public String updateCourse(@RequestBody Course course)
    {
        courseService.updateCourse(course);
        return "Course Updated Successfully";
    }

    @DeleteMapping("{id}")
    public String deleteCourse(@PathVariable("id") Long id)
    {
        courseService.deleteCourse(id);
        return "Course Deleted Successfully";
    }

}
