package com.alansf.apidiariodebordo.repositories;

import com.alansf.apidiariodebordo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
