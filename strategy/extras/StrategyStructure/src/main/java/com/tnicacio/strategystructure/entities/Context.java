package com.tnicacio.strategystructure.entities;

import com.tnicacio.strategystructure.services.Strategy;

/**
 * The Context maintains a reference to one of the concrete
 * strategies and communicates with this object only via the
 * strategy interface
 */
public class Context {

    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * The context calls the execution method on the linked strategy object each time
     * it needs to run the algorithm. The context doesn’t know what type of strategy
     * it works with or how the algorithm is executed.
     *
     * @param data Some data that the strategy might use
     * @return String Result from execution method on the linked strategy object
     */
    public String doSomething(String data) {
        return strategy.execute(data);
    }

}
