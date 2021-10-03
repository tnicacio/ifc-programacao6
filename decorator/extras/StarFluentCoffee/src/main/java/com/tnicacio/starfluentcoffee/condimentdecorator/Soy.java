package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.coststrategy.SoyCost;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage, new SoyCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

}
