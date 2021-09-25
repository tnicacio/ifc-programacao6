package com.tnicacio.mathoperator.calculator;

import com.tnicacio.mathoperator.mathstrategy.MathStrategy;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class CalculatorTest {

    @Nested
    public class SetStrategy {

        @Test
        void shouldSetStrategy() {
            Calculator calculator = mock(Calculator.class);
            MathStrategy dummyStrategy = (a, b) -> a.add(b);

            calculator.setStrategy(dummyStrategy);

            verify(calculator, only()).setStrategy(dummyStrategy);
        }

    }

    @Nested
    public class ExecuteStrategy {

        @Test
        void shouldCallLinkedStrategyExecutionMethod() {
            Calculator calculator = spy(Calculator.class);
            MathStrategy linkedStrategy = mock(MathStrategy.class);
            calculator.setStrategy(linkedStrategy);

            calculator.executeStrategy(new BigDecimal("2"), new BigDecimal("3"));

            InOrder inOrder = inOrder(calculator, linkedStrategy);
            inOrder.verify(calculator).executeStrategy(new BigDecimal("2"), new BigDecimal("3"));
            inOrder.verify(linkedStrategy).execute(new BigDecimal("2"), new BigDecimal("3"));
        }

        @Test
        void shouldThrowNullPointerExceptionWhenLinkedStrategyIsNotSetted() {
            Calculator calculator = spy(Calculator.class);

            assertThrows(NullPointerException.class, () -> {
                calculator.executeStrategy(new BigDecimal("2"), new BigDecimal("3"));
            });
        }

    }

}