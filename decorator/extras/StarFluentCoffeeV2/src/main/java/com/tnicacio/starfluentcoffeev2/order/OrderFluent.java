package com.tnicacio.starfluentcoffeev2.order;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.CondimentDecorator;
import com.tnicacio.starfluentcoffee.enums.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderFluent implements OrderWithCondiments.SizeOrder, OrderWithCondiments.CondimentsOrder, OrderWithCondiments.CostOrder {

    private final List<CondimentDecorator> condiments = new ArrayList<>();
    private Beverage beverage;
    private Size size;

    public OrderFluent(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public OrderWithCondiments.CondimentsOrder size(Size size) {
        Objects.requireNonNull(size, "Size is required");
        this.size = size;
        return this;
    }

    @Override
    public OrderWithCondiments.CondimentsOrder add(CondimentDecorator condiment) {
        condiments.add(condiment);
        return this;
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        cost += condiments.stream().mapToDouble(Beverage::cost).sum();
        return cost;
    }

}
