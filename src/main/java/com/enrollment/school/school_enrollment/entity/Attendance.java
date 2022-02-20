package com.enrollment.school.school_enrollment.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.MODULE)
@Data
@Entity
@Table(name = "attendance", uniqueConstraints = { @UniqueConstraint(columnNames = { "student_id", "date" }) })
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    private Student student;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    @JsonProperty(required = true)
    private Boolean isPresent;

    public Attendance(Student student, LocalDate dateTime, boolean isPresent) {
        this(student, isPresent);
        this.date = dateTime == null ? this.date : dateTime;
    }

    public Attendance(Student student, boolean isPresent) {
        this.student = student;
        this.date = LocalDate.now();
        this.isPresent = isPresent;
    }

    public String getStudent() {
        return student.getUser().getName();
    }

    public Integer getRollNumber() {
        return student.getRoleId();
    }
}
