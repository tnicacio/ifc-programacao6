package com.tnicacio.starbuzzcoffee2000.sizedecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class MediumBeverage extends SizeDecorator {

    public MediumBeverage(Beverage beverage) {
        super(beverage, Size.MEDIUM);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", MEDIUM";
    }

}
