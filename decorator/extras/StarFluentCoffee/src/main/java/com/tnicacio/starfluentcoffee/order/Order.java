package com.tnicacio.starfluentcoffee.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;

import java.util.Objects;

public interface Order {

    static SizeOrder beverage(Beverage beverage) {
        Objects.requireNonNull(beverage, "Beverage is required to the order");
        return new OrderFluent(beverage);
    }

    interface SizeOrder {
        CondimentsOrder size(Size size);
    }

    interface CondimentsOrder {
        CheckoutOrder add(Condiment condiment);
    }

    interface CheckoutOrder extends CondimentsOrder {
        Beverage checkout();
    }

}
