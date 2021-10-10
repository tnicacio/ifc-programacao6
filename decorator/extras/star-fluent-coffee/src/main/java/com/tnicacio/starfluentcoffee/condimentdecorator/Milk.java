package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.coststrategy.MilkCost;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage, new MilkCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

}
