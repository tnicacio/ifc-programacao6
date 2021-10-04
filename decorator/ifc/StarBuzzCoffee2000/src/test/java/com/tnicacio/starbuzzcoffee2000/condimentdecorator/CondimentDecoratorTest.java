package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.CostStrategy;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.test.factory.CondimentDecoratorDefaultImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

class CondimentDecoratorTest {

    private CondimentDecorator condimentDecorator;
    private Beverage beverage;
    private CostStrategy costStrategy;

    @BeforeEach
    void setUp() {
        beverage = Mockito.mock(Beverage.class);
        costStrategy = Mockito.mock(CostStrategy.class);

        condimentDecorator = Mockito.mock(CondimentDecorator.class, Mockito.CALLS_REAL_METHODS);
        condimentDecorator.beverage = beverage;
        condimentDecorator.setCostStrategy(costStrategy);
    }

    @Nested
    class Constructor {
        @Test
        void shouldSetBeverage() {
            condimentDecorator = new CondimentDecoratorDefaultImpl(beverage, costStrategy);
            assertThat(condimentDecorator.beverage).isEqualTo(beverage);
        }

        @Test
        void shouldSetCostStrategy() {
            condimentDecorator = new CondimentDecoratorDefaultImpl(beverage, costStrategy);
            assertThat(condimentDecorator.getCostStrategy()).isEqualTo(costStrategy);
        }
    }

    @Nested
    class GetAndSetSize {

        @Test
        void shouldExecuteBeverageGetSize() {
            InOrder inOrder = Mockito.inOrder(condimentDecorator, beverage);

            condimentDecorator.getSize();

            inOrder.verify(condimentDecorator).getSize();
            inOrder.verify(beverage).getSize();
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldExecuteBeverageSetSize() {
            InOrder inOrder = Mockito.inOrder(condimentDecorator, beverage);
            Size size = Size.SMALL;

            condimentDecorator.setSize(size);

            inOrder.verify(condimentDecorator).setSize(size);
            inOrder.verify(beverage).setSize(size);
            inOrder.verifyNoMoreInteractions();
        }
    }

    @Nested
    class Cost {
        @Test
        void shouldExecuteCostStrategyCostMethod() {
            InOrder inOrder = Mockito.inOrder(condimentDecorator, costStrategy);

            condimentDecorator.cost();

            inOrder.verify(condimentDecorator).cost();
            inOrder.verify(costStrategy).cost(beverage);
            inOrder.verifyNoMoreInteractions();
        }
    }

}