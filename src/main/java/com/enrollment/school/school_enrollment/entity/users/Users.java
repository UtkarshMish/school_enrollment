package com.enrollment.school.school_enrollment.entity.users;

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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Users {
    public Users() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
            @Size(min = 0, max = 200) int age, @Pattern(regexp = "^(?=.*\\d).{10}$") String phone, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
        this.phone = phone;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role.getName();
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
