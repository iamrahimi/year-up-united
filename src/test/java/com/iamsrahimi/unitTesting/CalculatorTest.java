package com.iamsrahimi.unitTesting;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class CalculatorTest {
    private final Calculator calculator = new Calculator();
    private static final double DELTA = 0.0001;

    @Test
    void addTwoNumbers() {
        assertEquals(4.0, calculator.add(2.0, 2.0), DELTA);
    }

    @Test
    void subtractTwoNumbers() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), DELTA);
    }

    @Test
    void multiplyTwoNumbers() {
        assertEquals(12.0, calculator.multiply(3.0, 4.0), DELTA);
    }

    @Test
    void divideTwoNumbers() {
        assertEquals(4.0, calculator.divide(8.0, 2.0), DELTA);
    }
}
