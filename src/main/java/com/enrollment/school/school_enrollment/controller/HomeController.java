package com.enrollment.school.school_enrollment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    @GetMapping("/{name}")
    public String homePage(@PathVariable String name) {
        return "index";
    }
}
