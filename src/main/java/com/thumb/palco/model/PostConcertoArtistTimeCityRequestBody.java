package com.thumb.palco.model;

public class PostConcertoArtistTimeCityRequestBody {

    public String artist;
    public String time;
    public String city;

    public PostConcertoArtistTimeCityRequestBody() {
    }

    public PostConcertoArtistTimeCityRequestBody(String artist, String time, String city) {
        this.artist = artist;
        this.time = time;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
