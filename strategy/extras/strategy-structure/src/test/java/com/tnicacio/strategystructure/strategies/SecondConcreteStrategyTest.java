package com.tnicacio.strategystructure.strategies;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SecondConcreteStrategyTest {

    @Test
    void executeShouldReturnTheStringDataDuplicated() {
        SecondConcreteStrategy secondConcreteStrategy = new SecondConcreteStrategy();
        String anyData = "Any data";

        String result = secondConcreteStrategy.execute(anyData);

        assertThat(result).isEqualTo(anyData + anyData);
    }

}
