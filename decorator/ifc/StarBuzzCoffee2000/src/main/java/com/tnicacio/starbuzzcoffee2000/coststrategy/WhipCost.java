package com.tnicacio.starbuzzcoffee2000.beverage.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

import java.util.Objects;

public class WhipCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined beforehand");
        if (size == Size.MEDIUM) {
            return .10 + beverage.cost();
        }
        if (size == Size.SMALL) {
            return .06 + beverage.cost();
        }
        if (size == Size.BIG) {
            return .14 + beverage.cost();
        }
        throw new IllegalArgumentException("Invalid size");
    }

}
