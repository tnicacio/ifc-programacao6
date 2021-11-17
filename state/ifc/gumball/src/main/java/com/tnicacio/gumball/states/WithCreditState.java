package com.tnicacio.gumball.states;

import com.tnicacio.gumball.entities.GumballMachine;
import com.tnicacio.gumball.entities.enums.StateType;

import java.util.Random;

public class WithCreditState implements State {

    private GumballMachine gumballMachine;

    public WithCreditState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertCoin() {
        throw new IllegalStateException("Cannot insert another coin!");
    }

    @Override
    public void ejectCoin() {
        gumballMachine.setStateType(StateType.NO_CREDIT);
    }

    @Override
    public void turnCrank() {
        if (new Random().nextInt(10) == 7) {
            gumballMachine.setStateType(StateType.WINNER);
        } else {
            gumballMachine.setStateType(StateType.SOLD);
        }
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("No gumball dispensed!");
    }

}
