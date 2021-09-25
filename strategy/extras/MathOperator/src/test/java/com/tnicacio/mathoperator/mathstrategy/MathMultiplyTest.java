package com.tnicacio.mathoperator.mathstrategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathMultiplyTest {

    @Test
    void executeShouldReturnFirstNumberMultipliedBySecondNumber() {
        MathMultiply mathMultiply = new MathMultiply();

        BigDecimal result = mathMultiply.execute(new BigDecimal("3"), new BigDecimal("2"));

        assertEquals(new BigDecimal("6"), result);
    }

}