package com.alansf.apidiariodebordo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.rmi.registry.Registry;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {
}