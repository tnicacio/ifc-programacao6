package com.tnicacio.starbuzzcoffee2000.sizedecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.test.factory.SizeBigDecoratorDefaultImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

class SizeDecoratorTest {

    private SizeDecorator sizeDecorator;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = Mockito.spy(Beverage.class);

        sizeDecorator = Mockito.mock(SizeDecorator.class, Mockito.CALLS_REAL_METHODS);
        sizeDecorator.beverage = beverage;
    }

    @Nested
    class Constructor {
        @Test
        void shouldSetBeverage() {
            sizeDecorator = new SizeBigDecoratorDefaultImpl(beverage);
            Assertions.assertThat(sizeDecorator.beverage).isEqualTo(beverage);
        }

        @Test
        void shouldExecuteBeverageSetSize() {
            sizeDecorator = new SizeBigDecoratorDefaultImpl(beverage);
            Mockito.verify(beverage).setSize(Size.BIG);
        }
    }


    @Nested
    class Cost {
        @Test
        void shouldExecuteBeverageCost() {
            InOrder inOrder = Mockito.inOrder(sizeDecorator, beverage);

            sizeDecorator.cost();

            inOrder.verify(sizeDecorator).cost();
            inOrder.verify(beverage).cost();
            inOrder.verifyNoMoreInteractions();
        }
    }

    @Nested
    class GetAndSetSize {
        @Test
        void shouldExecuteBeverageGetSize() {
            InOrder inOrder = Mockito.inOrder(sizeDecorator, beverage);

            sizeDecorator.getSize();

            inOrder.verify(sizeDecorator).getSize();
            inOrder.verify(beverage).getSize();
            inOrder.verifyNoMoreInteractions();
        }

        @Test
        void shouldExecuteBeverageSetSize() {
            InOrder inOrder = Mockito.inOrder(sizeDecorator, beverage);
            Size size = Size.SMALL;

            sizeDecorator.setSize(size);

            inOrder.verify(sizeDecorator).setSize(size);
            inOrder.verify(beverage).setSize(size);
            inOrder.verifyNoMoreInteractions();
        }
    }

}