package com.enrollment.school.school_enrollment.controller;

import java.util.HashMap;
import java.util.List;

import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.service.RolesService;
import com.enrollment.school.school_enrollment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    @Autowired
    private final UserService userService;
    @Autowired
    private final RolesService rolesService;


    @GetMapping("/users")
    public ResponseEntity<List<Users>> usersList() {
        return ResponseEntity.ok(userService
                .findAll());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> roleList() {
        return ResponseEntity.ok(rolesService.findAll());
    }

    @PostMapping("/users")
    public ResponseEntity<Users> createUser(@RequestBody Users user) {

        Role role = rolesService.findByName(user.getRole());
        if (role != null) {
            user.setRole(role);
        }
        return ResponseEntity.ok(userService
                .save(user));
    }

    @DeleteMapping("/users/all")
    public ResponseEntity<HashMap<String, Boolean>> deleteUsers() {
        userService.removeAll();
        var response = new HashMap<String, Boolean>();
        response.put("Success", true);
        return ResponseEntity.ok(response);
    }
}
