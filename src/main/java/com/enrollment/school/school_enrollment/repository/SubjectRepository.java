package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.subject.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
