package com.proyecto.lair.dto.youtube;

public class YouTubeSnippetDTO {
    String publishedAt;
    String channelId;
    String title;
    String description;

    public YouTubeSnippetDTO() {
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
