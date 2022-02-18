package com.enrollment.school.school_enrollment.models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StudentModel implements Serializable {
    private String name;
    private String email;
    private String phone;
    private Integer age;
    private String password;
    private Number fees;
}
