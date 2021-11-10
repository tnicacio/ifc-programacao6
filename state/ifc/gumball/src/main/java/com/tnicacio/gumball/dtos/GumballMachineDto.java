package com.tnicacio.gumball.dtos;

import com.tnicacio.gumball.entities.GumballMachine;
import com.tnicacio.gumball.entities.enums.StateType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class GumballMachineDto {

    private UUID id;

    @Min(value = 0, message = "Must be at least {value}")
    @NotNull(message = "The number of gumballs must not be null")
    private Long numberGumballs;

    private StateType stateType;

    public  GumballMachineDto() {
    }

    public GumballMachineDto(Long numberGumballs, StateType stateType) {
        this.numberGumballs = numberGumballs;
        this.stateType = stateType;
    }

    public GumballMachineDto(GumballMachine entity) {
        this.id = entity.getId();
        this.numberGumballs = entity.getNumberGumballs();
        this.stateType = entity.getStateType();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getNumberGumballs() {
        return numberGumballs;
    }

    public void setNumberGumballs(Long numberGumballs) {
        this.numberGumballs = numberGumballs;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

}
