package com.tnicacio.strategystructure.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstConcreteStrategyTest {

    @Test
    void executeShouldReturnTheSameStringData() {
        FirstConcreteStrategy firstConcreteStrategy = new FirstConcreteStrategy();
        String anyData = "Any data";

        String result = firstConcreteStrategy.execute(anyData);

        assertThat(result).isEqualTo(anyData);
    }

}
