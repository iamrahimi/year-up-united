package com.sayedrahimi.personalassetmanager.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class VehicleTest {
    @Test
    void currentValueDropsByTenPercentForEachFullYear() {
        Vehicle vehicle = new Vehicle("Family car", LocalDate.of(2020, 11, 20),
                new BigDecimal("10000.00"), "Honda", "CR-V", 2020);

        BigDecimal value = vehicle.getCurrentValue(LocalDate.of(2022, 11, 20));

        assertEquals(new BigDecimal("8100.00"), value);
    }
}
