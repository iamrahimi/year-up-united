package com.iamsrahimi.unitTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    @Test
    void addTwoNumbers() {
        Calculator calculator = new Calculator();

        assertEquals(5, calculator.add(2, 3));
    }
}