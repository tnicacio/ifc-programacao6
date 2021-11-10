package com.tnicacio.gumball.states;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.GumballMachine;

public interface State {

    void insertCoin();

    void ejectCoin();

    void turnCrank();

    void dispense();

    void setMachine(GumballMachineDto gumballMachine);

}
