package com.example.demo1.service;

import com.example.demo1.model.College;

import java.util.List;
import java.util.Optional;

public interface CollegeService {
    public String createCollege(College college);
    public String updateCollege(College college);
    public String deleteCollege(Long collegeId);
    public List<College> getCollegeDetailsByCourse(Long collegeId);
    public List<College> getAllColleges();
    public College getCollege(Long id);
}
