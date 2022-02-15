package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.subject.Assessments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentRepository extends JpaRepository<Assessments, Integer> {

}
