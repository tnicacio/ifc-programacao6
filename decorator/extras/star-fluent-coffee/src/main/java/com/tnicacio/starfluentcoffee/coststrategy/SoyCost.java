package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.EnumMapValidatorUtil;

import java.util.EnumMap;
import java.util.Objects;

public class SoyCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        double cost = beverage.cost();

        EnumMap<Size, Double> map = new EnumMap<>(Size.class);
        map.put(Size.SMALL, cost + .10);
        map.put(Size.MEDIUM, cost + .15);
        map.put(Size.BIG, cost + 0.20);

        EnumMapValidatorUtil.validateKeys(Size.class, map, "Sizes map");
        return map.getOrDefault(size, cost);
    }

}
