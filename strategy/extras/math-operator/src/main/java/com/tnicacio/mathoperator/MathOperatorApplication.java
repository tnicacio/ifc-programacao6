package com.tnicacio.mathoperator;

import com.tnicacio.mathoperator.calculator.Calculator;
import com.tnicacio.mathoperator.mathstrategy.MathAdd;
import com.tnicacio.mathoperator.mathstrategy.MathDivide;
import com.tnicacio.mathoperator.mathstrategy.MathMultiply;
import com.tnicacio.mathoperator.mathstrategy.MathSubtract;

import java.math.BigDecimal;

public class MathOperatorApplication {

    public static void main(String... args) {

        Calculator calculator = new Calculator();

        BigDecimal firstNumber = new BigDecimal("8");
        BigDecimal secondNumber = new BigDecimal("2");
        String action = "addition";

        if ("addition".equals(action)) {
            calculator.setStrategy(new MathAdd());
        }
        if ("subtraction".equals(action)) {
            calculator.setStrategy(new MathSubtract());
        }
        if ("multiplication".equals(action)) {
            calculator.setStrategy(new MathMultiply());
        }
        if ("division".equals(action)) {
            calculator.setStrategy(new MathDivide());
        }

        BigDecimal result = calculator.executeStrategy(firstNumber, secondNumber);
        System.out.println(result);

    }

}
