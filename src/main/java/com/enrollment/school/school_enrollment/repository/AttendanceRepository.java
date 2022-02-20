package com.enrollment.school.school_enrollment.repository;

import java.time.LocalDate;
import java.util.List;

import com.enrollment.school.school_enrollment.entity.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {

    @Query("SELECT atdns FROM Attendance AS atdns WHERE student.id=:id")
    public List<Attendance> findByStudentId(@Param("id") Integer id);

    @Query("SELECT atdns FROM Attendance AS atdns WHERE atdns.date=:date")
    public List<Attendance> findAllByDate(@Param("date") LocalDate date);

}
