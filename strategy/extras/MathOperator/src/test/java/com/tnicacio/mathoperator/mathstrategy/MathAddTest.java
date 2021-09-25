package com.tnicacio.mathoperator.mathstrategy;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MathAddTest {

    @Test
    void executeShouldReturnFirstNumberPlusToSecondNumber() {
        MathAdd mathAdd = new MathAdd();

        BigDecimal result = mathAdd.execute(new BigDecimal("3"), new BigDecimal("2"));

        assertEquals(new BigDecimal("5"), result);
    }

}