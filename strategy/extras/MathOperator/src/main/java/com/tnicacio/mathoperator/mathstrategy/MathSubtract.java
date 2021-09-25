package com.tnicacio.mathoperator.mathstrategy;

import java.math.BigDecimal;

public class MathSubtract implements MathStrategy {

    @Override
    public BigDecimal execute(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

}
