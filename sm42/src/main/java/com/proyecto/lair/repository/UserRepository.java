package com.proyecto.lair.repository;

import com.proyecto.lair.model.Userv2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Userv2, Integer>{


    Optional<Userv2> findByName(String username);
}
