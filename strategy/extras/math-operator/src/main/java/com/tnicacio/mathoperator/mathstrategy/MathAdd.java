package com.tnicacio.mathoperator.mathstrategy;

import java.math.BigDecimal;

public class MathAdd implements MathStrategy {

    @Override
    public BigDecimal execute(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

}
