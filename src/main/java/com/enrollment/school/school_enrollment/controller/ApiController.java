package com.enrollment.school.school_enrollment.controller;

import java.util.HashMap;
import java.util.List;

import com.enrollment.school.school_enrollment.entity.Fees;
import com.enrollment.school.school_enrollment.entity.subject.Assessments;
import com.enrollment.school.school_enrollment.entity.subject.Subject;
import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.service.AssessmentService;
import com.enrollment.school.school_enrollment.service.FeesService;
import com.enrollment.school.school_enrollment.service.RolesService;
import com.enrollment.school.school_enrollment.service.SubjectService;
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

    @Autowired
    private final SubjectService subjectService;

    @Autowired
    private final AssessmentService assessmentService;

    @Autowired
    private final FeesService feesService;

    @GetMapping("/users")
    public ResponseEntity<List<Users>> usersList() {
        return ResponseEntity.ok(userService
                .findAll());
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> roleList() {
        return ResponseEntity.ok(rolesService.findAll());
    }

    @GetMapping("/subject")
    public ResponseEntity<List<Subject>> subjectList() {
        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/fees")
    public ResponseEntity<List<Fees>> feesList() {
        return ResponseEntity.ok(feesService.findAll());
    }

    @PostMapping("/student")
    public ResponseEntity<Fees> createFees(@RequestBody Fees fees) {
        String roleName = fees.getUser().getRole();
        if (roleName.equals("student")) {
            final Users user = userService.findOne(fees.getUser().getName());
            final Role role = rolesService.findByName(roleName);
            fees.getUser().setRole(role == null ? rolesService.save(new Role(fees.getUser().getRole())) : role);

            fees.setUser(user == null ? userService.save(fees.getUser()) : user);
            return ResponseEntity.ok(feesService.save(fees));

        } else
            return ResponseEntity.badRequest().body(null);
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

    @PostMapping("/subject")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        for (Assessments assessments : subject.getAssessmentList()) {
            assessmentService.save(assessments);
        }
        return ResponseEntity.ok(subjectService
                .save(subject));
    }

    @DeleteMapping("/users/all")
    public ResponseEntity<HashMap<String, Boolean>> deleteUsers() {
        userService.removeAll();
        var response = new HashMap<String, Boolean>(1);
        response.put("Success", true);
        return ResponseEntity.ok(response);
    }
}
