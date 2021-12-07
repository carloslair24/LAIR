package com.proyecto.lair.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.nimbusds.jose.shaded.json.JSONArray;
import com.nimbusds.jose.shaded.json.JSONObject;
import com.proyecto.lair.dto.MiDTO;
import com.proyecto.lair.model.Userv2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.proyecto.lair.dto.UserDTO;
import com.proyecto.lair.repository.UserRepository;
import com.proyecto.lair.exception.BusinessException;
import com.proyecto.lair.service.AuthenticationService;
import com.proyecto.lair.service.UserService;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Value("${spring.security.jwt.token.prefix}")
    private String tokenPrefix;

    @Value("${spring.security.jwt.expiration.time}")
    private Long expirationTime;

    @Value("${spring.security.oauth2.resourceserver.jwt.key-value}")
    private RSAPublicKey publicKey;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Override
    public JSONObject loginAuthentication(String username, String rawPassword) {
        Optional<Userv2> user = userRepository.findByName(username);

        if (!user.isPresent()) {
            // 401 Unauthorized
            throw new BusinessException("Access is denied due to invalid credentials.", HttpStatus.UNAUTHORIZED);
        }

        String encodedPassword = user.get().getPassword();
        boolean isAuthenticated = passwordEncoder.matches(rawPassword, encodedPassword);

        if (!isAuthenticated) {
            // 401 Unauthorized
            throw new BusinessException("Access is denied due to invalid credentials.", HttpStatus.UNAUTHORIZED);
        }

        String token = JWT.create().withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTime))
                .sign(Algorithm.HMAC512(publicKey.getEncoded()));


        MiDTO miDTO = new MiDTO();
        miDTO.setToken(tokenPrefix + token);
        JSONObject jsonObject = new JSONObject();
        JSONObject usuario = new JSONObject();
        jsonObject.put("permissions", new JSONArray());
        usuario.put("username", user.get().getName());
        usuario.put("role", user.get().getRole());
        jsonObject.put("user", usuario);
        jsonObject.put("token", miDTO.getToken());
        return jsonObject;

    }

    @Override
    @Transactional
    public UserDTO createUser(Userv2 entity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(entity.getName());
        userDTO.setStatus(entity.getStatus());
        userDTO.setPassword(passwordEncoder.encode(entity.getPassword()));
        userDTO.setRole((short) entity.getRole());
        return userService.saveUser(userDTO);
    }



    @Bean
    public UserService prueba(){return new UserService() {
        @Override
        public UserDTO saveUser(UserDTO userDTO) {
            return userDTO;
        }
    };}



}
