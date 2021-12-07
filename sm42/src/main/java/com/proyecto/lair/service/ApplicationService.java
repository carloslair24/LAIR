package com.proyecto.lair.service;

import com.proyecto.lair.dto.users.BeeceptorDTO;
import com.proyecto.lair.dto.youtube.YouTubeDTO;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface ApplicationService {
    String firstService();
    BeeceptorDTO testHttp() throws IOException;
    void saveMyFirstObject(String username, String pwd);
    YouTubeDTO mergeYoutube() throws IOException;
}
