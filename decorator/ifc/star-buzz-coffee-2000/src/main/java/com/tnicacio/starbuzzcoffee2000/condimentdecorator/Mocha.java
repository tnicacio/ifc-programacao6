package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.MochaCost;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage, new MochaCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

}
