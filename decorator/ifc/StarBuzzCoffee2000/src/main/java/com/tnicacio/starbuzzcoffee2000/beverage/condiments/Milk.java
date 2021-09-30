package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

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
        if (beverage.getSize() == Size.MEDIUM) {
            return .10 + beverage.cost();
        }
        if (beverage.getSize() == Size.SMALL) {
            return .05 + beverage.cost();
        }
        if (beverage.getSize() == Size.BIG) {
            return .15 + beverage.cost();
        }
        beverage.setSize(DEFAULT_SIZE);
        return cost();
    }

}
