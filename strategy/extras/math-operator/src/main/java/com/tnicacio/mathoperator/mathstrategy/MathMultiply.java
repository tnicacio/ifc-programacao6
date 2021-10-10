package com.tnicacio.mathoperator.mathstrategy;

import java.math.BigDecimal;

public class MathMultiply implements MathStrategy {

    @Override
    public BigDecimal execute(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

}
