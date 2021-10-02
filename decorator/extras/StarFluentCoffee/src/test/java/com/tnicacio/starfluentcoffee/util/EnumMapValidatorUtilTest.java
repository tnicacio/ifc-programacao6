package com.tnicacio.starfluentcoffee.util;

import com.tnicacio.starfluentcoffee.enums.Condiment;
import com.tnicacio.starfluentcoffee.util.EnumMapValidatorUtil;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EnumMapValidatorUtilTest {

    @Test
    void validateEmpty() {
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> EnumMapValidatorUtil.validate(Condiment.class, "Set", "condiments", () -> 0, condiment -> false, Condiment::name));
        assertEquals("Set is not complete: [[MILK], [MOCHA], [SOY], [WHIP]] (condiments in squire brackets are absent)", e.getMessage());
    }

    @Test
    void validateFull() {
        EnumMapValidatorUtil.validate(Condiment.class, "Set", "condiments", () -> Condiment.values().length, condiment -> true, Condiment::name);
        assertTrue(Condiment.values().length > 0);
    }

    @Test
    void validateFullSet() {
        EnumMapValidatorUtil.validateElements(Condiment.class, Set.of(Condiment.values()), "Condiment list");
        assertTrue(Condiment.values().length > 0);
    }

    @Test
    void validateMissingSet() {
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> EnumMapValidatorUtil.validateElements(Condiment.class, Set.of(Condiment.MILK, Condiment.MOCHA), "Condiments list"));
        assertEquals("Condiments list is not complete: [MILK, MOCHA, [SOY], [WHIP]] (elements in squire brackets are absent)", e.getMessage());
    }

    @Test
    void validateKeysInFullMap() {
        Map<Condiment, Integer> map = Stream.of(Condiment.values()).collect(Collectors.toMap(c -> c, Enum::ordinal));
        EnumMapValidatorUtil.validateKeys(Condiment.class, map, "Condiments map");
        assertEquals(Condiment.values().length, map.size());
    }

    @Test
    void validateKeysInMissingMap() {
        Map<Condiment, Integer> map = Stream.of(Condiment.values())
                .filter(c -> !Condiment.MOCHA.equals(c))
                .collect(Collectors.toMap(c -> c, Enum::ordinal));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> EnumMapValidatorUtil.validateKeys(Condiment.class, map, "Condiments map"));
        assertEquals("Condiments map is not complete: [MILK, [MOCHA], SOY, WHIP] (keys in squire brackets are absent)", e.getMessage());
    }

    @Test
    void validateValuesInFullMap() {
        Map<String, Condiment> map = Stream.of(Condiment.values()).collect(Collectors.toMap(Enum::name, c -> c));
        EnumMapValidatorUtil.validateValues(Condiment.class, map, "Condiments map");
    }

    @Test
    void validateValuesInMissingMap() {
        Map<Integer, Condiment> map = Stream.of(Condiment.values())
                .filter(c -> !Condiment.MILK.equals(c))
                .collect(Collectors.toMap(Enum::ordinal, c -> c));

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> EnumMapValidatorUtil.validateValues(Condiment.class, map, "Condiments map"));
        assertEquals("Condiments map is not complete: [[MILK], MOCHA, SOY, WHIP] (values in squire brackets are absent)", e.getMessage());
    }

}