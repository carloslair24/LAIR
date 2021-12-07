package com.proyecto.lair.model.dao;

import com.proyecto.lair.model.Userv2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<Userv2, Integer> {
    public Userv2 findByName(String name);
}
