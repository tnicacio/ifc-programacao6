package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.EnumMapValidatorUtil;

import java.util.EnumMap;
import java.util.Objects;

public class HouseBlendCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        EnumMap<Size, Double> map = new EnumMap<>(Size.class);
        map.put(Size.SMALL, .79);
        map.put(Size.MEDIUM, .89);
        map.put(Size.BIG, .99);

        EnumMapValidatorUtil.validateKeys(Size.class, map, "Sizes map");
        return map.get(size);
    }

}
