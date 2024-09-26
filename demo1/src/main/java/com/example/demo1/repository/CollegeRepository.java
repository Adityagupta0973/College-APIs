package com.example.demo1.repository;

import com.example.demo1.model.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CollegeRepository extends JpaRepository<College, Long>
{

    @Query("SELECT c FROM College c JOIN c.courses cs WHERE cs.id = :courseId")
    List<College> findByCourseId(@Param("courseId") Long courseId);
}
