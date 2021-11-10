package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;

import java.util.UUID;

public interface GumballMachineService extends GumballMachineCrudService {

    GumballMachineDto insertCoin(UUID id);

    GumballMachineDto ejectCoin(UUID id);

    GumballMachineDto turnCrank(UUID id);

    GumballMachineDto dispense(UUID id);

}
