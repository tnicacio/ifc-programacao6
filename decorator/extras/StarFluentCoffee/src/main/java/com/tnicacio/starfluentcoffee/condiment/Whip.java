package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.MEDIUM) {
            return .10 + beverage.cost();
        }
        if (beverage.getSize() == Size.SMALL) {
            return .06 + beverage.cost();
        }
        if (beverage.getSize() == Size.BIG) {
            return .14 + beverage.cost();
        }
        return beverage.cost();
    }

}
