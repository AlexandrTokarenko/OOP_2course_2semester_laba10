package com.example.laba10.fun;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FunctionTest {

    Function function;
    public final static double EPS = 1e-2;

    @BeforeEach
    void setUp() {
        function = new Function();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calc() {

        double x = 1;
        double expected = -0.9;
        double result = Function.calc(x);
        assertEquals(expected,result,1e-1);
    }
}