package com.alansf.apidiariodebordo.repositories;

import com.alansf.apidiariodebordo.entities.Registry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends JpaRepository<Registry, Integer> {

}