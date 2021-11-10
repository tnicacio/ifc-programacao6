package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;
import org.springframework.stereotype.Component;

@Component
public class NoCreditState implements State {

    private GumballMachineDto gumballMachine;

    @Override
    public void insertCoin() {
        gumballMachine.setStateType(StateType.WITH_CREDIT);
    }

    @Override
    public void ejectCoin() {
        throw new IllegalStateException("No coin inserted");
    }

    @Override
    public void turnCrank() {
        throw new IllegalStateException("Crank turned but no coin inserted");
    }

    @Override
    public void dispense() {
        throw new IllegalStateException("Crank turned but no coin inserted");
    }

    @Override
    public void setMachine(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

}
