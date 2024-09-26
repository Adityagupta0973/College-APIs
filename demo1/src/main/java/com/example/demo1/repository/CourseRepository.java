package com.example.demo1.repository;

import com.example.demo1.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long>
{
    List<Course> findByCollegeId(Long collegeId);
}
