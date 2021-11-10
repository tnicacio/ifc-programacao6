package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import org.springframework.stereotype.Component;

@Component
public class SoldOutState implements State {

    private GumballMachineDto gumballMachine;

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

    @Override
    public void setMachine(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

}
