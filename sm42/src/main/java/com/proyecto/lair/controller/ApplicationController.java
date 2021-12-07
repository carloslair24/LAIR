package com.proyecto.lair.controller;

import com.proyecto.lair.dto.users.BeeceptorDTO;
import com.proyecto.lair.dto.youtube.YouTubeDTO;
import com.proyecto.lair.exception.BusinessException;
import com.proyecto.lair.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/lair/")
public class ApplicationController {

    @Autowired
    ApplicationService applicationService;

    @ExceptionHandler({ BusinessException.class })
    @ResponseBody
    public ResponseEntity<String> userHandler(BusinessException ex) {
        return new ResponseEntity<String>(ex.getMessage(), ex.getHttpStatus());
    }

    @GetMapping("/")
    public String inicio(){return applicationService.firstService();
    }


    @GetMapping("/youtube")
    public YouTubeDTO youTubeDTO() throws IOException {
        YouTubeDTO yd = applicationService.mergeYoutube();
        return yd;
    }

    @GetMapping("/crear_usuario")
    public String guardar(@RequestParam("user") String username, @RequestParam("password") String pwd) throws IOException {
        applicationService.saveMyFirstObject(username,pwd);
        return "Cuenta creada exitosamente";
    }

}
