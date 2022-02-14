package com.enrollment.school.school_enrollment.controller;

import java.util.List;

import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.service.RolesService;
import com.enrollment.school.school_enrollment.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiController {

    private final UserService userService;
    private final RolesService rolesService;

    public ApiController(UserService userService, RolesService rolesService) {
        this.userService = userService;
        this.rolesService = rolesService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Users>> usersList() {
        return ResponseEntity.ok(userService
                .findAll());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> roleList() {
        return ResponseEntity.ok(rolesService.findAll());
    }
}
