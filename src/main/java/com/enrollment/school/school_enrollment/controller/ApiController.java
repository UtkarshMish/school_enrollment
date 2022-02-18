package com.enrollment.school.school_enrollment.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.enrollment.school.school_enrollment.entity.Student;
import com.enrollment.school.school_enrollment.entity.subject.Assessments;
import com.enrollment.school.school_enrollment.entity.subject.Subject;
import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.models.StudentModel;
import com.enrollment.school.school_enrollment.service.AssessmentService;
import com.enrollment.school.school_enrollment.service.RolesService;
import com.enrollment.school.school_enrollment.service.StudentService;
import com.enrollment.school.school_enrollment.service.SubjectService;
import com.enrollment.school.school_enrollment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
    /**
     *
     */

    @Autowired
    private final UserService userService;

    @Autowired
    private final StudentService studentService;
    @Autowired
    private final RolesService rolesService;

    @Autowired
    private final SubjectService subjectService;

    @Autowired
    private final AssessmentService assessmentService;

    @Autowired
    private final StudentService feesService;

    private final Map<String, Boolean> successResponse = Map.of("success", true);

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> sqlContstraintHandler(
            SQLIntegrityConstraintViolationException exception) {
        String errorMessage = exception.getLocalizedMessage().split("for")[0].trim();
        return ResponseEntity.badRequest().body(
                Map.of("error", errorMessage));

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

    @GetMapping("/subject")
    public ResponseEntity<List<Subject>> subjectList() {
        return ResponseEntity.ok(subjectService.findAll());
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> feesList() {
        return ResponseEntity.ok(feesService.findAll());
    }

    @PostMapping("/student")
    public ResponseEntity<Map<String, Boolean>> createStudent(
            @RequestBody StudentModel student) {
        final String STUDENT_ROLE = "student";
        Role role = rolesService.findByName(STUDENT_ROLE);
        if (role == null) {
            role = rolesService.save(new Role(STUDENT_ROLE));
        }
        studentService.save(
                new Users(student.getName(), student.getEmail(), student.getPassword(), student.getAge(),
                        student.getPhone(), role),
                student.getFees());
        return ResponseEntity.ok(successResponse);


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

    @DeleteMapping("/users/{userId}")
    public ResponseEntity<Map<String, Boolean>> deleteUsers(@PathVariable("userId") Integer userId) {
        try {
            Users user = userService.findOneById(userId);
            if (user != null) {
                boolean isStudent = user.getRole().equalsIgnoreCase("student");
                if (isStudent) {
                    studentService.deleteStudentFeesById(user.getId());
                }
                userService.removeOneById(userId);

            } else {
                throw new NullPointerException();
            }

        } catch (Exception e) {
            Logger.getGlobal().info(e.getMessage());
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(successResponse);
    }
}
