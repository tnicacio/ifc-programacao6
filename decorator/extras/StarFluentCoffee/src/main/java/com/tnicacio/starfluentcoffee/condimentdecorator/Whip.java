package com.tnicacio.starfluentcoffee.condimentdecorator;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.coststrategy.WhipCost;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage, new WhipCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

}
