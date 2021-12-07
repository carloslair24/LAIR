package com.proyecto.lair.dto.youtube;

public class YouTubeItemsDTO {
    String kind;
    String etag;
    String id;
    YouTubeSnippetDTO snippetDTO;

    public YouTubeItemsDTO() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSnippetDTO(YouTubeSnippetDTO snippetDTO) {
        this.snippetDTO = snippetDTO;
    }
}
