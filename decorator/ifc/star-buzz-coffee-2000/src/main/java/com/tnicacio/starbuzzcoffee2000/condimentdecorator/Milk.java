package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.MilkCost;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage, new MilkCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

}
