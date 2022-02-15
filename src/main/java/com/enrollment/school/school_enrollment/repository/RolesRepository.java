package com.enrollment.school.school_enrollment.repository;

import com.enrollment.school.school_enrollment.entity.users.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

    @Query("SELECT rol from Role AS rol WHERE rol.name = :name")
    public Role findByName(@Param("name") String name);
}
