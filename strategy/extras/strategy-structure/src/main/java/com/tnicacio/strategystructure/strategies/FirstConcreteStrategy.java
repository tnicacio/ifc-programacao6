package com.tnicacio.strategystructure.strategies;

/**
 * Concrete Strategies implement different variations of an algorithm the context uses.
 */
public class FirstConcreteStrategy implements Strategy {

    @Override
    public String execute(String data) {
        return data;
    }

}
