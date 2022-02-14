package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

}
