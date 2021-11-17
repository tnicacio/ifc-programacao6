package com.tnicacio.gumball.states;

import com.tnicacio.gumball.entities.GumballMachine;

public class SoldOutState implements State {

    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        throw new IllegalStateException("Sorry, we are out of gumballs");
    }

    @Override
    public void ejectCoin() {
        throw new IllegalStateException("No coin inserted");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("Sorry, we are out of gumballs");
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("No gumball dispensed");
    }

}
