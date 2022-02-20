package com.enrollment.school.school_enrollment.entity;

import com.enrollment.school.school_enrollment.entity.users.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor(access = AccessLevel.MODULE)
@AllArgsConstructor
@JsonInclude(content = Include.NON_EMPTY)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Integer roleId;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    private Users user;

    @NotNull(message = "Fees Amount Required")
    private Double fees;

    public Student(
            String name,
            String email, String password,
            Integer age, String phone,
            String role, Double fees) {
        this.user = new Users(name, email, password, age, phone, role);
        this.fees = fees;
    }

    public Student(Users user, Number fees) {
        this.user = user;
        this.fees = fees.doubleValue();
    }

    public void setUser(String name,
            String email, String password,
            Integer age, String phone,
            String role) {
        this.user = new Users(name, email, password, age, phone, role);
    }

    public <T extends Number> Student(T fees) {
        this.fees = fees.doubleValue();
    }
}
