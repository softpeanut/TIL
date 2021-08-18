package com.example.aoppractice2.controller;

import com.example.aoppractice2.annotation.PerformanceTimeRecord;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @PerformanceTimeRecord
    public String hello() {
        return "Hello world";
    }
}
