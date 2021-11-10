package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;
import org.springframework.stereotype.Component;

@Component
public class SoldState implements State {

    private GumballMachineDto gumballMachine;

    @Override
    public void insertCoin() {
        throw new IllegalStateException("Please wait while your gumball is being dispensed!");
    }

    @Override
    public void ejectCoin() {
        throw new IllegalStateException("Crank already turned!");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("Turning again will not give you another gumball ;/");
    }

    @Override
    public void dispense() {
        long newGumballCount = gumballMachine.getNumberGumballs() - 1;
        gumballMachine.setNumberGumballs(newGumballCount);

        if (newGumballCount == 0) {
            gumballMachine.setStateType(StateType.SOLD_OUT);
        } else {
            gumballMachine.setStateType(StateType.NO_CREDIT);
        }
    }

    @Override
    public void setMachine(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

}
