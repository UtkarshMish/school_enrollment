package com.enrollment.school.school_enrollment.entity.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Double id;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-z][a-z 0-9._]{0,200}[a-z0-9]$", flags = Flag.CASE_INSENSITIVE)
    @NotNull(message = "required value")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "required value")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "required value")
    private String password;

    @Column
    @Size(min = 0, max = 200)
    private int age;

    @Column
    @Pattern(regexp = "^(?=.*\\d).{10}$")
    private String phone;
    @OneToOne(mappedBy = "role")
    private Roles role;
}
