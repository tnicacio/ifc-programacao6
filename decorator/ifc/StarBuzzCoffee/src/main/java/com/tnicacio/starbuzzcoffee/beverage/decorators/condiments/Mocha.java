package com.tnicacio.starbuzzcoffee.beverage.decorators.condiments;

import com.tnicacio.starbuzzcoffee.beverage.Beverage;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }

}
