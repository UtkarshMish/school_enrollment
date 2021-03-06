package com.enrollment.school.school_enrollment.entity.users;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor(access = AccessLevel.MODULE)
@AllArgsConstructor
@JsonInclude(content = Include.NON_EMPTY)
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-z][a-z 0-9._]{0,200}[a-z0-9]$", flags = Flag.CASE_INSENSITIVE)
    @NotNull(message = "name is required")
    private String name;

    @Column(nullable = false, unique = true)
    @NotNull(message = "email is required")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "password is required")
    @Getter(value = AccessLevel.NONE)
    private String password;

    @Column
    @Min(0)
    @Max(100)
    private Integer age;

    @Column
    @Pattern(regexp = "^(?=.*\\d).{10}$")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Role.class, cascade = CascadeType.ALL)
    private Role role;

    public Users(
            @Pattern(regexp = "^[a-z][a-z 0-9._]{0,200}[a-z0-9]$", flags = Flag.CASE_INSENSITIVE) @NotNull(message = "required value") String name,
            @NotNull(message = "required value") String email, @NotNull(message = "required value") String password,
            @Min(0) @Max(100) Integer age, @Pattern(regexp = "^(?=.*\\d).{10}$") String phone, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.role = new Role(role);

    }

    public Users(
            @Pattern(regexp = "^[a-z][a-z 0-9._]{0,200}[a-z0-9]$", flags = Flag.CASE_INSENSITIVE) @NotNull(message = "required value") String name,
            @NotNull(message = "required value") String email, @NotNull(message = "required value") String password,
            @Min(0) @Max(100) Integer age, @Pattern(regexp = "^(?=.*\\d).{10}$") String phone, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.role = role;

    }

    public String getRole() {
        return this.role.getName();
    }



}
