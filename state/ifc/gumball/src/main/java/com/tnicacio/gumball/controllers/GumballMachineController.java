package com.tnicacio.gumball.controllers;

import com.tnicacio.gumball.dtos.GumballMachineDto;
import com.tnicacio.gumball.services.GumballMachineService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping(value = "/gumball-machines")
public class GumballMachineController {

    private final GumballMachineService service;

    public GumballMachineController(GumballMachineService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<GumballMachineDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok().body(service.findAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GumballMachineDto> findById(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<GumballMachineDto> insert(@RequestBody @Valid GumballMachineDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GumballMachineDto> update(@PathVariable UUID id, @RequestBody @Valid GumballMachineDto dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}/insert-coin")
    public ResponseEntity<GumballMachineDto> insertCoin(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.insertCoin(id));
    }

    @PutMapping(value = "/{id}/eject-coin")
    public ResponseEntity<GumballMachineDto> ejectCoin(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.ejectCoin(id));
    }

    @PutMapping(value = "/{id}/turn-crank")
    public ResponseEntity<GumballMachineDto> turnCrank(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.turnCrank(id));
    }

    @PutMapping(value = "/{id}/dispense")
    public ResponseEntity<GumballMachineDto> dispense(@PathVariable UUID id) {
        return ResponseEntity.ok().body(service.dispense(id));
    }

}
