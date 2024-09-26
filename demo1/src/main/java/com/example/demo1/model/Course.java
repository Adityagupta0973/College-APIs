package com.example.demo1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="courses")
public class Course
{
    @Id
    private Long id;
    private String name;
    private BigDecimal fee;
    private String duration;

    @ManyToOne
    @JoinColumn(name = "college_id")
    @JsonBackReference
    private College college;

    public Course(Long id, String name, BigDecimal fee, String duration, College college) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.duration = duration;
        this.college = college;
    }

    public Course() {
    }
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }
}