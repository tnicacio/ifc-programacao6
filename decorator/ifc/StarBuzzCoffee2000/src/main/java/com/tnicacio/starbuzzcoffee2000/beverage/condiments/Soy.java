package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

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
        beverage.setSize(DEFAULT_SIZE);
        return cost();
    }

}
