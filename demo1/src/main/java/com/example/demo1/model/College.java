package com.example.demo1.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="colleges")
public class College
{
    @Id
    private Long id;
    private String name;
    private String accommodationType;
    private BigDecimal accommodationFee;

    public College() {
    }

    public College(Long id, String name, String accommodationType, BigDecimal accommodationFee, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.accommodationType = accommodationType;
        this.accommodationFee = accommodationFee;
        this.courses = courses;
    }
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Course> courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(String accommodationType) {
        this.accommodationType = accommodationType;
    }

    public BigDecimal getAccommodationFee() {
        return accommodationFee;
    }

    public void setAccommodationFee(BigDecimal accommodationFee) {
        this.accommodationFee = accommodationFee;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
