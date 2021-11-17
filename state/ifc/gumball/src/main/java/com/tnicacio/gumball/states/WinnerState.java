package com.tnicacio.gumball.states;

import com.tnicacio.gumball.entities.GumballMachine;
import com.tnicacio.gumball.entities.enums.StateType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WinnerState implements State {

    Logger log = LoggerFactory.getLogger(WinnerState.class);

    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

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
        long currentGumballCount = gumballMachine.getNumberGumballs();

        if (currentGumballCount > 2) {
            gumballMachine.setNumberGumballs(currentGumballCount - 2);
            gumballMachine.setStateType(StateType.NO_CREDIT);
        } else if (currentGumballCount == 2) {
            log.info("Won 2 gumballs!");
            gumballMachine.setNumberGumballs(0L);
            gumballMachine.setStateType(StateType.SOLD_OUT);
        } else if (currentGumballCount == 1) {
            log.info("Winner but won only the last gumball!");
            gumballMachine.setNumberGumballs(0L);
            gumballMachine.setStateType(StateType.SOLD_OUT);
        } else {
            gumballMachine.setStateType(StateType.SOLD_OUT);
        }
    }

}
