package com.tnicacio.starfluentcoffee.condiment;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        if (beverage.getSize() == Size.MEDIUM) {
            return .15 + beverage.cost();
        }
        if (beverage.getSize() == Size.SMALL) {
            return .10 + beverage.cost();
        }
        if (beverage.getSize() == Size.BIG) {
            return .20 + beverage.cost();
        }
        return beverage.cost();
    }

}
