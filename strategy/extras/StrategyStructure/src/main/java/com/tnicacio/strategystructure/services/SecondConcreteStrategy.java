package com.tnicacio.strategystructure.services;

/**
 * Concrete Strategies implement different variations of an algorithm the context uses.
 */
public class SecondConcreteStrategy implements Strategy {

    @Override
    public String execute(String data) {
        return data + data;
    }

}
