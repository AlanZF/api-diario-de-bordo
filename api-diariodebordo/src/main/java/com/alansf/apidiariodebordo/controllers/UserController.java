package com.alansf.apidiariodebordo.controllers;

import com.alansf.apidiariodebordo.entities.User;
import com.alansf.apidiariodebordo.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("apidiary/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> readAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("{idUser}")
    public Optional<User> findUserById(@PathVariable Integer idUser) {
        return userService.findUserById(idUser);
    }

    @PutMapping("{idUser}")
    public User updateUser(@PathVariable Integer idUser,
                           @RequestBody User user) {
        Optional<User> optUser = userService.findUserById(idUser);
        User userReturn = null;

        if (optUser.isPresent()) {
            User us = optUser.get();
            us.setName(user.getName());
            us.setEmail(user.getEmail());
            us.setPassword(user.getPassword());
            userReturn = userService.updateUser(us);
        }
        return userReturn;
    }

    @DeleteMapping("{idUser}")
    public void deleteUser(@PathVariable Integer idUser) {
        Optional<User> optUser = userService.findUserById(idUser);
        if (optUser.isPresent()) {
            User user = optUser.get();
            userService.deleteUser(user);
        }
    }
}
