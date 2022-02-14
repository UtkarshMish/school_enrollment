package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.Marks;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkSheetRepository extends JpaRepository<Marks, Long> {

}
