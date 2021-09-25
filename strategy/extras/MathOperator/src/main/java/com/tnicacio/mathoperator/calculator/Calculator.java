package com.tnicacio.mathoperator.calculator;

import com.tnicacio.mathoperator.mathstrategy.MathStrategy;

import java.math.BigDecimal;

public class Calculator {

    private MathStrategy strategy;

    public void setStrategy(MathStrategy strategy) {
        this.strategy = strategy;
    }

    public BigDecimal executeStrategy(BigDecimal a, BigDecimal b) {
        return strategy.execute(a, b);
    }

}
