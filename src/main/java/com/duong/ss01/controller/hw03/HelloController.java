package com.duong.ss01.controller.hw03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String hello (Model model){
        model.addAttribute("hello","Hello, Spring Boot API!");
        return "hw03_hello";
    }
}
