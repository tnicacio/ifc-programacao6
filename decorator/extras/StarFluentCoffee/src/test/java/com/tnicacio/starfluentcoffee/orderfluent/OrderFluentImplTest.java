package com.tnicacio.starfluentcoffee.orderfluent;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condimentdecorator.Milk;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderFluentImplTest {

    private OrderFluentImpl orderFluentImpl;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = Mockito.mock(Beverage.class);
        orderFluentImpl = new OrderFluentImpl(beverage);
    }

    @Nested
    class FluentSize {

        @Test
        void shouldSetSizeAndGoToCheckoutOrder() {
            Size size = Size.SMALL;

            orderFluentImpl.size(size);

            Mockito.verify(beverage).setSize(size);
            assertThat(orderFluentImpl.size(size)).isInstanceOf(OrderFluent.CheckoutOrder.class);
        }

        @Test
        void shouldThrowNullPointerExceptionWhenSizeIsNull() {
            assertThatExceptionOfType(NullPointerException.class)
                    .isThrownBy(() -> orderFluentImpl.size(null))
                    .withMessage("Size is required");
        }

    }

    @Nested
    class FluentAdd {

        @Test
        void shouldDecorateBeverageWithCondiment() {
            Condiment condiment = Condiment.MILK;

            Beverage expectedNewBeverage = new Milk(beverage);
            orderFluentImpl.add(condiment);

            assertThat(orderFluentImpl.checkout())
                    .extracting(Beverage::getDescription)
                    .isEqualTo(expectedNewBeverage.getDescription());
        }

        @Test
        void shouldGoToCheckoutOrder() {
            assertThat(orderFluentImpl.add(Condiment.MILK)).isInstanceOf(OrderFluent.CheckoutOrder.class);
        }

    }

    @Nested
    class FluentCheckout {

        @Test
        void shouldReturnFinalFormOfBeverage() {
            assertThat(orderFluentImpl.checkout()).isInstanceOf(Beverage.class);
        }

    }

}