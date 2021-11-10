package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class WithCreditState implements State {

    private GumballMachineDto gumballMachine;

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

    @Override
    public void setMachine(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

}
