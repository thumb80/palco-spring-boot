package com.thumb.palco.model;

public class PostConcertoArtistTimeRequestBody {

    public String artist;
    public String time;

    public PostConcertoArtistTimeRequestBody() {
    }

    public PostConcertoArtistTimeRequestBody(String artist, String time) {
        this.artist = artist;
        this.time = time;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
