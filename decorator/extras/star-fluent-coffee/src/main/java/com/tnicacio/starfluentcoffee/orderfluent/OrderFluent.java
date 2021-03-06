package com.tnicacio.starfluentcoffee.orderfluent;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;

import java.util.Objects;

public interface OrderFluent {

    static SizeOrder beverage(Beverage beverage) {
        Objects.requireNonNull(beverage, "Beverage is required");
        return new OrderFluentImpl(beverage);
    }

    interface SizeOrder {
        CheckoutOrder size(Size size);
    }

    interface CondimentsOrder {
        CheckoutOrder add(Condiment condiment);
    }

    interface CheckoutOrder extends CondimentsOrder {
        Beverage checkout();
    }

}
