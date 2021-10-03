package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.EnumMapValidatorUtil;

import java.util.EnumMap;
import java.util.Objects;

public class DecafCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        EnumMap<Size, Double> map = new EnumMap<>(Size.class);
        map.put(Size.SMALL, .95);
        map.put(Size.MEDIUM, 1.05);
        map.put(Size.BIG, 1.15);

        EnumMapValidatorUtil.validateKeys(Size.class, map, "Sizes map");
        return map.get(size);
    }

}
