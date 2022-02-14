package com.enrollment.school.school_enrollment.entity.subject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor(access = AccessLevel.MODULE)
public class Assessments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double id;

    @Column(nullable = false, unique = true)
    private String name;

}