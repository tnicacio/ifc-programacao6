package com.tnicacio.starfluentcoffee.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.CondimentDecorator;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.mapper.CondimentToCondimentDecoratorWithBeverage;
import com.tnicacio.starfluentcoffee.mapper.Mapper;

import java.util.Objects;

public class OrderFluent implements Order.SizeOrder, Order.CondimentsOrder, Order.CheckoutOrder {

    private final Mapper<Condiment, CondimentDecorator, Beverage> condimentMapper = new CondimentToCondimentDecoratorWithBeverage();

    private Beverage beverage;

    public OrderFluent(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Order.CheckoutOrder size(Size size) {
        Objects.requireNonNull(size, "size is required");
        beverage.setSize(size);
        return this;
    }

    @Override
    public Order.CheckoutOrder add(Condiment condiment) {
        Objects.requireNonNull(condiment, "condiment must not be null");
        beverage = condimentMapper.map(condiment, beverage);
        return this;
    }

    @Override
    public Beverage checkout() {
        return beverage;
    }

}
