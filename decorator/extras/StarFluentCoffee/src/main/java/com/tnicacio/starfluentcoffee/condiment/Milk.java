package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.cost.MilkCost;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage, new MilkCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

}
