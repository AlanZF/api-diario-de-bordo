package com.alansf.apidiariodebordo.services;

import com.alansf.apidiariodebordo.entities.User;
import com.alansf.apidiariodebordo.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> readAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Integer idUser) {
        return userRepository.findById(idUser);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
}
