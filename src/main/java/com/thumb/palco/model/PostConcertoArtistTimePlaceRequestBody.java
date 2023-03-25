package com.thumb.palco.model;

public class PostConcertoArtistTimePlaceRequestBody {

    public String artist;
    public String time;
    public String place;

    public PostConcertoArtistTimePlaceRequestBody() {
    }

    public PostConcertoArtistTimePlaceRequestBody(String artist, String time, String place) {
        this.artist = artist;
        this.time = time;
        this.place = place;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
