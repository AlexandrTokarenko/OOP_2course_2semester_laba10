package com.example.laba10.fun;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadingCalculatorTest {

    ThreadingCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new ThreadingCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculate() {
        double a = 0;
        double b = Math.PI/2;
        int n = 100000;
        double expected = -0.4;
        double result = calculator.calculate(a,b,n);
        assertEquals(expected,result,1e-1);
    }
}