package com.proyecto.lair.dto.youtube;

import java.util.List;

public class YouTubeDTO {
    String kind;
    String etag;
    List<YouTubeItemsDTO> youtubelista;

    public YouTubeDTO() {
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public void setYoutubelista(List<YouTubeItemsDTO> youtubelista) {
        this.youtubelista = youtubelista;
    }
}
