package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.GumballMachine;
import com.tnicacio.gumball.repositories.GumballMachineRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Primary
@Service
public class GumballMachineServiceImpl extends GumballMachineCrudServiceImpl implements GumballMachineService {

    private final GumballMachineRepository repository;
    private final StateService stateService;

    public GumballMachineServiceImpl(GumballMachineRepository repository, StateService stateService) {
        super(repository);
        this.repository = repository;
        this.stateService = stateService;
    }

    @Override
    public GumballMachineDto insertCoin(UUID id) {
        GumballMachine gumballMachine = repository.getById(id);
        GumballMachineDto dto = new GumballMachineDto(gumballMachine);
        stateService.getStateFrom(dto).insertCoin();
        return super.update(id, dto);
    }

    @Override
    public GumballMachineDto ejectCoin(UUID id) {
        GumballMachine gumballMachine = repository.getById(id);
        GumballMachineDto dto = new GumballMachineDto(gumballMachine);
        stateService.getStateFrom(dto).ejectCoin();
        return super.update(id, dto);
    }

    @Override
    public GumballMachineDto turnCrank(UUID id) {
        GumballMachine gumballMachine = repository.getById(id);
        GumballMachineDto dto = new GumballMachineDto(gumballMachine);
        stateService.getStateFrom(dto).turnCrank();
        return super.update(id, dto);
    }

    @Override
    public GumballMachineDto dispense(UUID id) {
        GumballMachine gumballMachine = repository.getById(id);
        GumballMachineDto dto = new GumballMachineDto(gumballMachine);
        stateService.getStateFrom(dto).dispense();
        return update(id, dto);
    }

}
