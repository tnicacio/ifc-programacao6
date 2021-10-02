package com.tnicacio.starfluentcoffee.util;

import com.tnicacio.starfluentcoffee.beverage.Beverage;
import com.tnicacio.starfluentcoffee.condiment.Milk;
import com.tnicacio.starfluentcoffee.condiment.Mocha;
import com.tnicacio.starfluentcoffee.condiment.Soy;
import com.tnicacio.starfluentcoffee.condiment.Whip;
import com.tnicacio.starfluentcoffee.enums.Condiment;
import lombok.experimental.UtilityClass;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

@UtilityClass
public class CondimentDecoratorUtil {

    public Beverage decorate(Beverage beverage, Condiment condiment) {
        Objects.requireNonNull(beverage, "Beverage must not be null");
        Objects.requireNonNull(condiment, "Condiment must not be null");

        Map<Condiment, Beverage> map = new EnumMap<>(Condiment.class);
        map.put(Condiment.MILK, new Milk(beverage));
        map.put(Condiment.MOCHA, new Mocha(beverage));
        map.put(Condiment.SOY, new Soy(beverage));
        map.put(Condiment.WHIP, new Whip(beverage));

        EnumMapValidatorUtil.validateKeys(Condiment.class, map, "Condiments map");
        return map.getOrDefault(condiment, beverage);
    }

}
