package com.tnicacio.gumball.repositories;

import com.tnicacio.gumball.entities.GumballMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GumballMachineRepository extends JpaRepository<GumballMachine, UUID> {
}
