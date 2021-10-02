package com.tnicacio.starfluentcoffee.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.DecorateBeverageWithCondiment;
import com.tnicacio.starfluentcoffee.util.DecoratorUtil;

import java.util.Objects;

public class OrderFluent implements Order.SizeOrder, Order.CondimentsOrder, Order.CheckoutOrder {

    private final DecoratorUtil<Beverage, Condiment> decoratorUtil = new DecorateBeverageWithCondiment();

    private Beverage beverage;

    public OrderFluent(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Order.CheckoutOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        beverage.setSize(size);
        return this;
    }

    @Override
    public Order.CheckoutOrder add(Condiment condiment) {
        Objects.requireNonNull(condiment, "Condiment must not be null");
        beverage = decoratorUtil.decorate(beverage, condiment);
        return this;
    }

    @Override
    public Beverage checkout() {
        return beverage;
    }

}
