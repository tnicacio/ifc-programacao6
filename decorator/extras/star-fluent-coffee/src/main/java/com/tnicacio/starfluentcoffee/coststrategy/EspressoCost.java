package com.tnicacio.starfluentcoffee.coststrategy;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.enums.Size;
import com.tnicacio.starfluentcoffee.util.EnumMapValidatorUtil;

import java.util.EnumMap;
import java.util.Objects;

public class EspressoCost implements CostStrategy {

    @Override
    public double cost(Beverage beverage) {
        Size size = Objects.requireNonNull(beverage.getSize(), "Beverage size must be defined");

        EnumMap<Size, Double> map = new EnumMap<>(Size.class);
        map.put(Size.SMALL, 1.89);
        map.put(Size.MEDIUM, 1.99);
        map.put(Size.BIG, 2.09);

        EnumMapValidatorUtil.validateKeys(Size.class, map, "Sizes map");
        return map.get(size);
    }

}
