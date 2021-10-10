package com.tnicacio.starbuzzcoffee2000.coststrategy;

import com.tnicacio.starbuzzcoffee2000.beverage.Beverage;
import com.tnicacio.starbuzzcoffee2000.enums.Size;

import java.util.Objects;

public class HouseBlendCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined beforehand");
        if (size == Size.MEDIUM) {
            return .89;
        }
        if (size == Size.SMALL) {
            return .79;
        }
        if (size == Size.BIG) {
            return .99;
        }
        throw new IllegalArgumentException("Invalid beverage size");
    }

}
