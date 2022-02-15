package com.enrollment.school.school_enrollment.entity;

import com.enrollment.school.school_enrollment.entity.subject.Subject;
import com.enrollment.school.school_enrollment.entity.users.Users;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class)
    private Users student;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Subject.class)
    private Subject name;

    @Min(value = 0, message = "Marks should be greater than 0")
    @Max(value = 100, message = "Marks should be less than or equal to 100")
    @Column(nullable = true)
    private int score;

}
