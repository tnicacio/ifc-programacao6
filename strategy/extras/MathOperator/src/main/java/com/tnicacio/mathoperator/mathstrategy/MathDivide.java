package com.tnicacio.mathoperator.mathstrategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MathDivide implements MathStrategy {

    @Override
    public BigDecimal execute(BigDecimal a, BigDecimal b) {
        return a.divide(b, RoundingMode.HALF_UP);
    }

}
