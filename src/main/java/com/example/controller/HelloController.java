package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ge.Mao on 2018/4/7
 */
@RestController
public class HelloController {
    @GetMapping("hello")
    public String say() {
        return "Hello Spring!";
    }
}
