package com.tnicacio.starfluentcoffee.orderfluent;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.CondimentDecoratorUtil;

import java.util.Objects;

public class OrderFluentImpl implements OrderFluent.SizeOrder, OrderFluent.CondimentsOrder, OrderFluent.CheckoutOrder {

    private Beverage beverage;

    public OrderFluentImpl(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public OrderFluent.CheckoutOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        beverage.setSize(size);
        return this;
    }

    @Override
    public OrderFluent.CheckoutOrder add(Condiment condiment) {
        beverage = CondimentDecoratorUtil.decorate(beverage, condiment);
        return this;
    }

    @Override
    public Beverage checkout() {
        return beverage;
    }

}
