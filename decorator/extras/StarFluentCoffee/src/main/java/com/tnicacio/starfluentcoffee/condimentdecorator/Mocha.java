package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.coststrategy.MochaCost;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage, new MochaCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

}
