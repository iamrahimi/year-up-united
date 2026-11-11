package com.iamsrahimi.hotelOperations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    public void punchOut_shouldAddHoursWorked_sincePunchIn() {
        // arrange
        Employee employee = new Employee();
        double expectedHours = 8.0;

        // act
        employee.punchIn(9);  // 9:00
        employee.punchOut(17); // 17:00

        // assert
        assertEquals(expectedHours, employee.getHoursWorked(), 0.001);
    }

    @Test
    public void punchOut_shouldAddToExistingHoursWorked() {
        // arrange
        Employee employee = new Employee();
        employee.setHoursWorked(4.0);
        double expectedHours = 8.0;

        // act
        employee.punchIn(8);
        employee.punchOut(12);

        // assert
        assertEquals(expectedHours, employee.getHoursWorked(), 0.001);
    }
}