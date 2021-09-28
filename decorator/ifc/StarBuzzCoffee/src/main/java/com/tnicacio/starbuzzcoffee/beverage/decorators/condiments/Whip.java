package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }

}
