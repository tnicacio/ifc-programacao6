package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.enums.StateType;
import com.tnicacio.gumball.states.*;
import org.springframework.stereotype.Service;

@Service
public class StateService {

    private GumballMachineDto gumballMachine;

    public State getStateFrom(GumballMachineDto gumballMachine) {
        this.gumballMachine = gumballMachine;

        if (gumballMachine.getStateType() == StateType.NO_CREDIT) {
            State state = new NoCreditState();
            state.setMachine(gumballMachine);
            return state;
        }
        if (gumballMachine.getStateType() == StateType.WITH_CREDIT) {
            State state = new WithCreditState();
            state.setMachine(gumballMachine);
            return state;
        }
        if (gumballMachine.getStateType() == StateType.SOLD) {
            State state = new SoldState();
            state.setMachine(gumballMachine);
            return state;
        }
        if (gumballMachine.getStateType() == StateType.SOLD_OUT) {
            State state = new SoldOutState();
            state.setMachine(gumballMachine);
            return state;
        }
        if (gumballMachine.getStateType() == StateType.WINNER) {
            State state = new WinnerState();
            state.setMachine(gumballMachine);
            return state;
        }

        return null;
    }

}
