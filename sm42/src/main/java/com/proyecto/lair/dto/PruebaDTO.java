package com.proyecto.lair.dto;

import com.nimbusds.jose.shaded.json.JSONObject;

public class PruebaDTO {
    String permisisons;
    String username;
    String role;
    String user;
    String token;

    public PruebaDTO() {
    }

    public PruebaDTO(String permisisons, String username, String role, String user, String token) {
        this.permisisons = permisisons;
        this.username= username;
        this.role = role;
        this.user = user;
        this.token = token;
    }

    public PruebaDTO(String admin, JSONObject loginAuthentication, String pwd, String noeli, String asj) {

    }

    public String getPermisisons() {
        return permisisons;
    }

    public void setPermisisons(String permisisons) {
        this.permisisons = permisisons;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}