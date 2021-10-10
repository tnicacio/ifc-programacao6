package com.tnicacio.starbuzzcoffee2000.sizedecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class SmallBeverage extends SizeDecorator {

    public SmallBeverage(Beverage beverage) {
        super(beverage, Size.SMALL);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", SMALL";
    }

}
