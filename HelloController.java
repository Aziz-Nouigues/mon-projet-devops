package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    private final CalculatorService calculatorService;

    public HelloController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return calculatorService.add(a, b);
    }
}