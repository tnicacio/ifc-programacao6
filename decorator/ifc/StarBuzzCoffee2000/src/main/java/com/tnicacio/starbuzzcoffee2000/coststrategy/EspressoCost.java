package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

import java.util.Objects;

public class EspressoCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined beforehand");
        if (size == Size.MEDIUM) {
            return 1.99;
        }
        if (size == Size.SMALL) {
            return 1.89;
        }
        if (size == Size.BIG) {
            return 2.09;
        }
        throw new IllegalArgumentException("Invalid beverage size");
    }

}
