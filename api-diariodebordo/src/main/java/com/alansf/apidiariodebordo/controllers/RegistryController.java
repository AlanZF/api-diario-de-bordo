package com.alansf.apidiariodebordo.controllers;

import com.alansf.apidiariodebordo.entities.Registry;
import com.alansf.apidiariodebordo.entities.User;
import com.alansf.apidiariodebordo.services.RegistryService;
import com.alansf.apidiariodebordo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("apidiary/registries")
public class RegistryController {

    private final RegistryService regService;
    private final UserService userService;

    @PostMapping
    public Registry createRegistry(@PathVariable Integer idUser, @RequestBody Registry reg) {
        Optional<User> optUser = userService.findUserById(idUser);

        Registry regReturn = null;
        if(optUser.isPresent()) {
            User user = optUser.get();
            reg.setUser(user);
            regReturn = regService.createRegistry(reg);
        }
        return regReturn;
    }

    @GetMapping
    public List<Registry> readAllRegistries() {
        return regService.readAllRegistries();
    }

    @GetMapping("{idReg}")
    public Optional<Registry> findRegistryById(@PathVariable Integer idReg) {
        return regService.findRegistryById(idReg);
    }

    @PutMapping("{idReg}")
    public Registry updateRegistry(@PathVariable Integer idReg,
                           @RequestBody Registry registry) {
        Optional<Registry> optReg = regService.findRegistryById(idReg);

        Registry regReturn = null;
        if (optReg.isPresent()) {
            Registry reg = optReg.get();
            reg.setDate(registry.getDate());
            reg.setPeriod(registry.getPeriod());
            reg.setTimeEstimated(registry.getTimeEstimated());
            reg.setActivity(registry.getActivity());
            reg.setActivityObjective(registry.getActivityObjective());
            reg.setStatus(registry.getStatus());
            regReturn = regService.updateRegistry(reg);
        }
        return regReturn;
    }

    @DeleteMapping("{idReg}")
    public void deleteRegistry(@PathVariable Integer idReg) {
        Optional<Registry> optReg = regService.findRegistryById(idReg);
        if (optReg.isPresent()) {
            Registry reg = optReg.get();
            regService.deleteRegistry(reg);
        }
    }

}
