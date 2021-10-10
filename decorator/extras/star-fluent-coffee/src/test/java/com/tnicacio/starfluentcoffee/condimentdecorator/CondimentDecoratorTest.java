package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.coststrategy.CostStrategy;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.test.factory.CondimentDecoratorDefaultImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class CondimentDecoratorTest {

    private CondimentDecorator condimentDecorator;
    private Beverage beverage;
    private CostStrategy costStrategy;

    @BeforeEach
    void setUp() {
        beverage = Mockito.spy(Beverage.class);
        costStrategy = Mockito.mock(CostStrategy.class);

        condimentDecorator = Mockito.spy(CondimentDecorator.class);
        condimentDecorator.beverage = beverage;
        condimentDecorator.setCostStrategy(costStrategy);
    }

    @Nested
    class GetSize {

        @Test
        void shouldCallBeverageGetSize() {
            InOrder inOrder = Mockito.inOrder(condimentDecorator, beverage);

            condimentDecorator.getSize();

            inOrder.verify(condimentDecorator).getSize();
            inOrder.verify(beverage).getSize();
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldReturnBeverageSize() {
            Assertions.assertThat(condimentDecorator.getSize()).isEqualTo(beverage.getSize());
        }

    }

    @Nested
    class SetSize {

        @Test
        void shouldCallBeverageSetSize() {
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

        @Test
        void shouldReturnCostFromCostStrategy() {
            Assertions.assertThat(condimentDecorator.cost()).isEqualTo(costStrategy.cost(beverage));
        }

    }

    @Nested
    class Constructor{

        @Test
        void shouldSetBeverage() {
            CondimentDecorator condimentDecorator = new CondimentDecoratorDefaultImpl(beverage);
            Assertions.assertThat(condimentDecorator.beverage).isEqualTo(beverage);
        }

        @Test
        void shouldInitializeWithCostStrategy() {
            CondimentDecorator condimentDecorator = new CondimentDecoratorDefaultImpl(beverage);
            Assertions.assertThat(condimentDecorator.cost()).isNotNull();
        }

    }

}