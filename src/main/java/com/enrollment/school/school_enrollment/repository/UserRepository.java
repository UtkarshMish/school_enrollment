package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.users.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
