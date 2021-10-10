package com.tnicacio.starbuzzcoffee2000.sizedecorator;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public class BigBeverage extends SizeDecorator {

    public BigBeverage(Beverage beverage) {
        super(beverage, Size.BIG);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", BIG";
    }

}
