package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;

public class Milk extends CondimentDecorator {

    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.SMALL) {
            return beverage.cost() + .10;
        }
        if (beverage.getSize() == Size.MEDIUM) {
            return beverage.cost() + .15;
        }
        if (beverage.getSize() == Size.BIG) {
            return beverage.cost() + .20;
        }
        return beverage.cost();
    }

}
