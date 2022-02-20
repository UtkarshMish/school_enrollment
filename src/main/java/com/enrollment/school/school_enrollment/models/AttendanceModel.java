package com.enrollment.school.school_enrollment.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class AttendanceModel {
    private Integer rollNo;
    private boolean present;
    private LocalDate date;
}
