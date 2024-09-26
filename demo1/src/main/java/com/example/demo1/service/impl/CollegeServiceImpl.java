package com.example.demo1.service.impl;

import com.example.demo1.model.College;
import com.example.demo1.repository.CollegeRepository;
import com.example.demo1.service.CollegeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollegeServiceImpl implements CollegeService {
    CollegeRepository collegeRepository;
    public CollegeServiceImpl(CollegeRepository collegeRepository) {
        this.collegeRepository = collegeRepository;
    }

    @Override
    public String createCollege(College college) {
        collegeRepository.save(college);
        return "College Created Successfully";
    }

    @Override
    public String updateCollege(College college) {
        collegeRepository.save(college);
        return "College Updated Successfully";
    }

    @Override
    public String deleteCollege(Long collegeId) {
        collegeRepository.deleteById(collegeId);
        return "College Deleted Successfully";
    }

    @Override
    public List<College> getCollegeDetailsByCourse(Long courseId) {
        return collegeRepository.findByCourseId(courseId);
    }

    @Override
    public List<College> getAllColleges() {return collegeRepository.findAll();}

    @Override
    public College getCollege(Long id) {
        return collegeRepository.findById(id).orElse(null);
    }
}
