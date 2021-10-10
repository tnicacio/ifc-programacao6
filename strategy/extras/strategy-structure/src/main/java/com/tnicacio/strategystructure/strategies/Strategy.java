package com.tnicacio.strategystructure.strategies;


/**
 * The Strategy interface is common to all concrete strategies.
 * It declares a method the context uses to execute a strategy.
 */
public interface Strategy {

    public String execute(String data);

}
