package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.cost.SoyCost;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage, new SoyCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

}
