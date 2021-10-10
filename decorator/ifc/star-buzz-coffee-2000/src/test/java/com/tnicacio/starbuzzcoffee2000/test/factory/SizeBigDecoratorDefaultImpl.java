package com.tnicacio.starbuzzcoffee2000.test.factory;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;
import com.tnicacio.starbuzzcoffee2000.sizedecorator.SizeDecorator;

public class SizeBigDecoratorDefaultImpl extends SizeDecorator {

    protected Beverage beverage;

    public SizeBigDecoratorDefaultImpl(Beverage beverage) {
        super(beverage, Size.BIG);
    }

    @Override
    public String getDescription() {
        return "Size Big Default Test";
    }

}
