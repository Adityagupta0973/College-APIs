package com.example.demo1.controller;

import com.example.demo1.model.College;
import com.example.demo1.service.CollegeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/colleges")
@CrossOrigin(origins = "*")
public class CollegeController
{
    CollegeService collegeService;

    public CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    @GetMapping()
    public List<College> getAllColleges() {return collegeService.getAllColleges();}

    @GetMapping("/course/{courseId}")
    public List<College> getCollegeByCourse(@PathVariable Long courseId) {
        return (List<College>) collegeService.getCollegeDetailsByCourse(courseId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<College> getCollegeById(@PathVariable Long id) {
        College college = collegeService.getCollege(id);

        if (college == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        // College will include the list of courses
        return ResponseEntity.ok(college);
    }

    @PostMapping
    public String createCloudVendorDetails(@RequestBody College college)
    {
        collegeService.createCollege(college);
        return "College Created Successfully";
    }

    @PutMapping
    public String updateCloudVendorDetails(@RequestBody College college)
    {
        collegeService.updateCollege(college);
        return "College Updated Successfully";
    }

    @DeleteMapping("{id}")
    public String deleteCloudVendorDetails(@PathVariable("id") Long id)
    {
        collegeService.deleteCollege(id);
        return "College Deleted Successfully";
    }
}