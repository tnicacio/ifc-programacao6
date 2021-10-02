package com.tnicacio.starfluentcoffee.cost;

import com.tnicacio.starfluentcoffee.beverage.Beverage;

import java.util.Objects;

public class HouseBlendCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        switch (beverage.getSize()) {
            case SMALL:
                return .79;
            case MEDIUM:
                return .89;
            case BIG:
                return .99;
        }
        return 0.0;
    }

}
