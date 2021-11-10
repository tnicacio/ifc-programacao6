package com.tnicacio.gumball.services;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.entities.GumballMachine;
import com.tnicacio.gumball.entities.enums.StateType;
import com.tnicacio.gumball.repositories.GumballMachineRepository;
import com.tnicacio.gumball.services.exceptions.DatabaseException;
import com.tnicacio.gumball.services.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;

@Service
public class GumballMachineCrudServiceImpl implements GumballMachineCrudService {

    private final GumballMachineRepository repository;

    public GumballMachineCrudServiceImpl(GumballMachineRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<GumballMachineDto> findAll(Pageable pageable) {
        Page<GumballMachine> list = repository.findAll(pageable);
        return list.map(GumballMachineDto::new);
    }

    @Transactional(readOnly = true)
    public GumballMachineDto findById(UUID id) {
        Optional<GumballMachine> obj = repository.findById(id);
        GumballMachine entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new GumballMachineDto(entity);
    }

    @Transactional
    public GumballMachineDto insert(GumballMachineDto dto) {
        if (dto.getNumberGumballs() == 0) {
            dto.setStateType(StateType.SOLD_OUT);
        } else {
            dto.setStateType(StateType.NO_CREDIT);
        }

        GumballMachine entity = new GumballMachine(dto.getNumberGumballs(), dto.getStateType());
        entity = repository.save(entity);
        return new GumballMachineDto(entity);
    }

    @Transactional
    public GumballMachineDto update(UUID id, GumballMachineDto dto) {
        try {
            GumballMachine entity = repository.getById(id);
            entity.setNumberGumballs(dto.getNumberGumballs());
            entity.setStateType(dto.getStateType());
            entity = repository.save(entity);
            return new GumballMachineDto(entity);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
    }

    public void delete(UUID id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

}
