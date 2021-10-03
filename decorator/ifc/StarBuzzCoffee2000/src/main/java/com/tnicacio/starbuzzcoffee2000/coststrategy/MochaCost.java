package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

import java.util.Objects;

public class MochaCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined beforehand");
        if (size == Size.MEDIUM) {
            return .20 + beverage.cost();
        }
        if (size == Size.SMALL) {
            return .15 + beverage.cost();
        }
        if (size == Size.BIG) {
            return .25 + beverage.cost();
        }
        throw new IllegalArgumentException("Invalid beverage size");
    }

}
