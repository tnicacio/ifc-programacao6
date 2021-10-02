package com.tnicacio.starfluentcoffeev2.condiment;

import com.tnicacio.starfluentcoffeev2.beverage.Beverage;
import com.tnicacio.starfluentcoffeev2.enums.Size;

public class Milk extends CondimentDecorator {

    public Milk() {
        super();
    }

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
