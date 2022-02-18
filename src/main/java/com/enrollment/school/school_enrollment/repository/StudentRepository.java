package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Transactional
    @Modifying
    @Query("DELETE FROM Student studnt where user.id = :id")
    public void deleteStudentById(@Param("id") Integer id);
}
