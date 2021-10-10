package com.tnicacio.starbuzzcoffee2000.condimentdecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.coststrategy.SoyCost;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage, new SoyCost());
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

}
