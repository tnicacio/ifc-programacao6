package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

}
