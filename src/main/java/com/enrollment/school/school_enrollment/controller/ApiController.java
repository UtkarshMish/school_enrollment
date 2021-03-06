package com.enrollment.school.school_enrollment.controller;

import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.enrollment.school.school_enrollment.entity.Attendance;
import com.enrollment.school.school_enrollment.entity.Student;
import com.enrollment.school.school_enrollment.entity.subject.Assessments;
import com.enrollment.school.school_enrollment.entity.subject.Subject;
import com.enrollment.school.school_enrollment.entity.users.Role;
import com.enrollment.school.school_enrollment.entity.users.Users;
import com.enrollment.school.school_enrollment.models.AttendanceModel;
import com.enrollment.school.school_enrollment.models.StudentModel;
import com.enrollment.school.school_enrollment.service.AssessmentService;
import com.enrollment.school.school_enrollment.service.AttendanceService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ApiController {
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
    private final AttendanceService attendanceService;

    private final Map<String, Boolean> successResponse = Map.of("success", true);

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> exceptionHandler(
            SQLIntegrityConstraintViolationException exception) {
        String errorMessage = splitExceptionMessage(exception);
        return ResponseEntity.badRequest().body(
                Map.of("error", errorMessage));

    }

    private <S extends Exception> String splitExceptionMessage(S exception) {
        return exception.getLocalizedMessage().split("for")[0].trim();
    }


    @GetMapping("/roles")
    public ResponseEntity<List<Role>> roleList() {
        return ResponseEntity.ok(rolesService.findAll());
    }

    @GetMapping("/subject")
    public ResponseEntity<List<Subject>> subjectList() {
        return ResponseEntity.ok(subjectService.findAll());
    }

    @PostMapping("/subject")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        for (Assessments assessments : subject.getAssessmentList()) {
            assessmentService.save(assessments);
        }
        return ResponseEntity.ok(subjectService
                .save(subject));
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> feesList() {
        return ResponseEntity.ok(studentService.findAll());
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

    @GetMapping("/users")
    public ResponseEntity<List<Users>> usersList() {
        return ResponseEntity.ok(userService
                .findAll());
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

    @GetMapping("/attendance")
    public ResponseEntity<List<Attendance>> attendanceList(
            @RequestParam("date") CharSequence date) {
        if (date != null) {
            return ResponseEntity.ok(attendanceService.findAllByDate(LocalDate.parse(date)));
        }
        return ResponseEntity.ok(attendanceService.findAll());
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<List<Attendance>> getStudentAttendance(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(attendanceService.findByStudentId(id));
    }

    @PostMapping("/attendance")
    public ResponseEntity<Map<String, Boolean>> addAttendances(@RequestBody List<AttendanceModel> attendances) {

        attendanceService.saveAll(

                attendances.stream().map(
                        student -> new Attendance(
                                studentService.findById(
                                        student.getRollNo()),
                                student.getDate(),
                                student.isPresent()))
                        .toList());

        return ResponseEntity.ok(successResponse);
    }
}
