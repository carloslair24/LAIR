package com.proyecto.lair.service.impl;

import com.google.gson.JsonArray;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.proyecto.lair.dto.users.*;
import com.proyecto.lair.dto.youtube.*;
import com.proyecto.lair.exception.BusinessException;
import com.proyecto.lair.model.*;
import com.proyecto.lair.repository.UserRepository;
import com.proyecto.lair.service.ApplicationService;
import com.proyecto.lair.service.HttpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    HttpService httpService;

    @Autowired
    UserRepository userRepository;
    @Override
    public String firstService(){
        return "service";
    }


    @Override
    public BeeceptorDTO testHttp() throws IOException {
        JsonParser parser = new JsonParser();
        JsonObject json = (JsonObject) parser.parse(httpService.sendRequestHttpS("https://utsm42.free.beeceptor.com","GET",null,null,"json",null, null));
        BeeceptorDTO beeceptorDTO = new BeeceptorDTO();

        if(json.get("code")== null){
            throw new BusinessException("Code doesn´t exist", HttpStatus.FORBIDDEN);
        }
        beeceptorDTO.setCode(json.get("code").getAsString());
        beeceptorDTO.setMessage(json.get("message").getAsString());
        beeceptorDTO.setStatus(json.get("status").getAsString());
        return beeceptorDTO;
    }
    @Override
    public void saveMyFirstObject(String name, String pwd){
        Userv2 userv2 = new Userv2();
        userv2.setName(name);
        userv2.setPassword(passwordEncoder.encode(pwd));
        userv2.setStatus("succes");
        userv2.setRole(1);
        userRepository.save(userv2);
    }

    @Override
    public YouTubeDTO mergeYoutube() throws IOException {
        YouTubeDTO yd = new YouTubeDTO();
        JsonParser pr = new JsonParser();
        JsonObject json = (JsonObject) pr.parse(httpService.sendRequestHttpS("https://www.googleapis.com/youtube/v3/videos?id=FUJDBXaKBcA&key=AIzaSyC-XbXXpngMiW6CFfPUsoZvQpcuki6nYvI&part=snippet","GET",null,null,"json",null, null));
        yd.setKind(json.get("kind").getAsString());
        yd.setEtag(json.get("etag").getAsString());
        JsonArray listas = json.getAsJsonArray("items");
        List<YouTubeItemsDTO> youtubeDTOList = new ArrayList<>();
        for(int x = 0 ; x > listas.size(); x++){
            JsonObject job1 = listas.get(x).getAsJsonObject();
            YouTubeItemsDTO y1 = new YouTubeItemsDTO();
            y1.setKind(job1.get("kind").getAsString());
            y1.setEtag(job1.get("etag").getAsString());
            y1.setId(job1.get("id").getAsString());
            YouTubeSnippetDTO snippetDTO = new YouTubeSnippetDTO();
            JsonObject snippetobject = job1.get("snippet").getAsJsonObject();
            snippetDTO.setPublishedAt(snippetobject.get("publishedAt").getAsString());
            snippetDTO.setChannelId(snippetobject.get("channelId").getAsString());
            snippetDTO.setTitle(snippetobject.get("title").getAsString());
            snippetDTO.setDescription(snippetobject.get("description").getAsString());
            y1.setSnippetDTO(snippetDTO);
            youtubeDTOList.add(y1);
        }
        yd.setYoutubelista(youtubeDTOList);
        return yd;
    }


}
