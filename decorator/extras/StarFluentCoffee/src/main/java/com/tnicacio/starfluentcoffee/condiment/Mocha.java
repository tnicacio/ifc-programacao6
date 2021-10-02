package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.cost.MochaCost;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage, new MochaCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

}
