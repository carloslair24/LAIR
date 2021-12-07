package com.proyecto.lair.service;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.proyecto.lair.dto.UserDTO;
import com.proyecto.lair.model.Userv2;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    /**
     *
     * @param username
     * @param rawPassword
     * @return
     */
    JSONObject loginAuthentication(String username, String rawPassword);
    UserDTO createUser(Userv2 entity);
}
