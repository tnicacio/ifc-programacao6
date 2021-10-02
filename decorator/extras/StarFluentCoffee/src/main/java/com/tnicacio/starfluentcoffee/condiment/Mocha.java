package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;

public class Mocha extends CondimentDecorator {

    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.MEDIUM) {
            return .20 + beverage.cost();
        }
        if (beverage.getSize() == Size.SMALL) {
            return .15 + beverage.cost();
        }
        if (beverage.getSize() == Size.BIG) {
            return .25 + beverage.cost();
        }
        return beverage.cost();
    }
    
}
