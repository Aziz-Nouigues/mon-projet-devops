package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {
    private final CalculatorService calculator = new CalculatorService();

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
    }
}