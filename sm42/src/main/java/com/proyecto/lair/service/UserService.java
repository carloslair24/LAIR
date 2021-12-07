package com.proyecto.lair.service;

import com.proyecto.lair.dto.UserDTO;
import org.springframework.stereotype.Service;


@Service
public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
}
