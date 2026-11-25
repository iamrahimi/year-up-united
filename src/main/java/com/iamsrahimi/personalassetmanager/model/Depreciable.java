package com.iamsrahimi.personalassetmanager.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public interface Depreciable {
    BigDecimal getOriginalCost();
    LocalDate getDateAcquired();
    BigDecimal getAnnualDepreciationRate();

    default BigDecimal getCurrentValue(LocalDate asOfDate) {
        long yearsOwned = ChronoUnit.YEARS.between(getDateAcquired(), asOfDate);
        BigDecimal value = getOriginalCost();
        BigDecimal yearlyMultiplier = BigDecimal.ONE.subtract(getAnnualDepreciationRate());

        for (int year = 0; year < yearsOwned; year++) {
            value = value.multiply(yearlyMultiplier);
        }

        if (value.compareTo(BigDecimal.ZERO) < 0) {
            value = BigDecimal.ZERO;
        }
        return value.setScale(2, java.math.RoundingMode.HALF_UP);
    }
}
