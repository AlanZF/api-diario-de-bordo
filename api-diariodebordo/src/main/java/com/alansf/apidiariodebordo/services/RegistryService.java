package com.alansf.apidiariodebordo.services;

import com.alansf.apidiariodebordo.entities.Registry;
import com.alansf.apidiariodebordo.repositories.RegistryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistryService {

    private RegistryRepository regRepository;

    public Registry createRegistry(Registry reg) {
        return regRepository.save(reg);
    }

    public List<Registry> readAllRegistries() {
        return regRepository.findAll();
    }

    public Optional<Registry> findRegistryById(Integer idReg) {
        return regRepository.findById(idReg);
    }

    public Registry updateRegistry(Registry reg) {
        return regRepository.save(reg);
    }

    public void deleteRegistry(Registry reg) {
        regRepository.delete(reg);
    }
}
