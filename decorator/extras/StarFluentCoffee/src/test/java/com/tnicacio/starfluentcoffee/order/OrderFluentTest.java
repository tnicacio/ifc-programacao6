package com.tnicacio.starfluentcoffee.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.Milk;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class OrderFluentTest {

    private OrderFluent orderFluent;
    private Beverage beverage;

    @BeforeEach
    void setUp() {
        beverage = Mockito.mock(Beverage.class);
        orderFluent = new OrderFluent(beverage);
    }

    @Nested
    class FluentSize {

        @Test
        void shouldSetSizeAndGoToCheckoutOrder() {
            Size size = Size.SMALL;

            orderFluent.size(size);

            Mockito.verify(beverage).setSize(size);
            assertThat(orderFluent.size(size)).isInstanceOf(Order.CheckoutOrder.class);
        }

        @Test
        void shouldThrowNullPointerExceptionWhenSizeIsNull() {
            assertThatExceptionOfType(NullPointerException.class)
                    .isThrownBy(() -> orderFluent.size(null))
                    .withMessage("Size is required");
        }

    }

    @Nested
    class FluentAdd {

        @Test
        void shouldDecorateBeverageWithCondiment() {
            Condiment condiment = Condiment.MILK;

            Beverage expectedNewBeverage = new Milk(beverage);
            orderFluent.add(condiment);

            assertThat(orderFluent.checkout())
                    .extracting(Beverage::getDescription)
                    .isEqualTo(expectedNewBeverage.getDescription());
        }

        @Test
        void shouldGoToCheckoutOrder() {
            assertThat(orderFluent.add(Condiment.MILK)).isInstanceOf(Order.CheckoutOrder.class);
        }

    }

    @Nested
    class FluentCheckout {

        @Test
        void shouldReturnFinalFormOfBeverage() {
            assertThat(orderFluent.checkout()).isInstanceOf(Beverage.class);
        }

    }

}