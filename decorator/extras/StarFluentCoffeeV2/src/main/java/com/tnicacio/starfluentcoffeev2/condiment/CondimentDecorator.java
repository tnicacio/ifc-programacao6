package com.tnicacio.starfluentcoffeev2.condiment;

import com.tnicacio.starfluentcoffeev2.beverage.Beverage;
import com.tnicacio.starfluentcoffeev2.enums.Size;

public abstract class CondimentDecorator implements Beverage {

    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public Size getSize() {
        return beverage.getSize();
    }

    @Override
    public void setSize(Size size) {
        beverage.setSize(size);
    }

}
