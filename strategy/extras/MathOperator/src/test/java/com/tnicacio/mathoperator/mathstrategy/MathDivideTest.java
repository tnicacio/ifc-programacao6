package com.tnicacio.mathoperator.mathstrategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathDivideTest {

    @Test
    void executeShouldReturnFirstNumberDividedBySecondNumber() {
        MathDivide mathDivide = new MathDivide();

        BigDecimal result = mathDivide.execute(new BigDecimal("6"), new BigDecimal("2"));

        assertEquals(new BigDecimal("3"), result);
    }

}