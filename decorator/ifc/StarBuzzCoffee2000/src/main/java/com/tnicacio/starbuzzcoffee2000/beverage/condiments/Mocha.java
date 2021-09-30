package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

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
        beverage.setSize(DEFAULT_SIZE);
        return cost();
    }

}
