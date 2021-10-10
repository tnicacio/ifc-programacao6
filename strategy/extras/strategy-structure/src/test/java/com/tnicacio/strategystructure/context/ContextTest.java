package com.tnicacio.strategystructure.context;

import com.tnicacio.strategystructure.strategies.Strategy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

class ContextTest {

    @Nested
    public class SetStrategy {

        @Test
        void shouldSetStrategy() {
            Context context = mock(Context.class);
            Strategy dummyStrategy = data -> data;

            context.setStrategy(dummyStrategy);

            verify(context).setStrategy(dummyStrategy);
        }

    }

    @Nested
    public class DoSomething {

        @Test
        void shouldCallLinkedStrategyExecutionMethod() {
            Context context = spy(Context.class);
            Strategy dummyStrategy = mock(Strategy.class);
            context.setStrategy(dummyStrategy);
            String someData = "dummy data";

            context.doSomething(someData);

            InOrder inOrder = inOrder(context, dummyStrategy);
            inOrder.verify(context).setStrategy(dummyStrategy);
            inOrder.verify(context).doSomething(someData);
            inOrder.verify(dummyStrategy).execute(someData);
        }

        @Test
        void shouldThrowNullPointerExceptionWhenStrategyIsNotSetted() {
            Context context = spy(Context.class);
            String someData = "dummy data";

            assertThrows(NullPointerException.class, () -> {
                context.doSomething(someData);
            });
        }

    }

}