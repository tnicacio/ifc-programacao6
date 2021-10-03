package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.WhipCost;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage, new WhipCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

}
