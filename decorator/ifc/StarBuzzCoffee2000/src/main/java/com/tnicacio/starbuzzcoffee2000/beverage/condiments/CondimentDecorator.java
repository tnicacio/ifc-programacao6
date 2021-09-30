package com.tnicacio.starbuzzcoffee2000.beverage.condiments;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

public abstract class CondimentDecorator implements Beverage {

    protected final Size DEFAULT_SIZE = Size.MEDIUM;
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
