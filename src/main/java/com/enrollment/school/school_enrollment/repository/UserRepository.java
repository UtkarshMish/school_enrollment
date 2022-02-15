package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.users.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT usr FROM Users AS usr WHERE usr.name = :name")
    public Users findByName(@Param("name") String name);

}
