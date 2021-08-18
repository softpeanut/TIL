package com.example.aoppractice2.controller;

import com.example.aoppractice2.annotation.PerformanceTimeRecord;
import com.example.aoppractice2.annotation.PersonInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @PerformanceTimeRecord
    public String hello() {
        return "Hello world";
    }

    @GetMapping("/info")
    @PersonInfo
    @PerformanceTimeRecord
    public String info() {
        System.out.println("info");
        return "name : 김범진, "
                + "number : 1302";
    }
}
