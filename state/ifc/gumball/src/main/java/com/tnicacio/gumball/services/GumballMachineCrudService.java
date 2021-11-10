package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface GumballMachineCrudService {

    Page<GumballMachineDto> findAll(Pageable pageable);

    GumballMachineDto findById(UUID id);

    GumballMachineDto insert(GumballMachineDto dto);

    GumballMachineDto update(UUID id, GumballMachineDto dto);

    void delete(UUID id);

}
