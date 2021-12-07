package com.proyecto.lair.resource;

import com.proyecto.lair.repository.UserRepository;
import com.proyecto.lair.response.Respuesta;
import com.proyecto.lair.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import static com.proyecto.lair.constants.AuthenticationConstants.URL_PRIVATE_AUTHETICATION;

@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS })
@RequestMapping(path = URL_PRIVATE_AUTHETICATION, produces= MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/iniciar_sesion")
    public Respuesta loginv1(@RequestParam("user") String username, @RequestParam("password") String pwd) {
        return new Respuesta(200,"Sesión iniciada",authenticationService.loginAuthentication(username,pwd));
    }


    @GetMapping("/obtener_nombre")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getSubject());
    }

    @GetMapping("/test")
    String test(){
        return "Exitoso";
    }



}