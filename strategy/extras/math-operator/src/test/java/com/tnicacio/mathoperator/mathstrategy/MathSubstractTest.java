package com.tnicacio.mathoperator.mathstrategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathSubstractTest {

    @Test
    void executeShouldReturnFirstNumberMinusSecondNumber() {
        MathSubtract mathSubtract = new MathSubtract();

        BigDecimal result = mathSubtract.execute(new BigDecimal("3"), new BigDecimal("2"));

        assertEquals(new BigDecimal("1"), result);
    }

}