package com.enrollment.school.school_enrollment.service;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.repository.RolesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class RolesService {
    @Autowired
    private RolesRepository rolesRepository;

    public Role save(Role roles) {
        return rolesRepository.save(roles);
    }

    public Role findByName(String name) {
        return rolesRepository.findByName(name);
    }

    public List<Role> findAll() {
        return rolesRepository.findAll();
    }
}