package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

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
        beverage.setSize(DEFAULT_SIZE);
        return cost();
    }

}
