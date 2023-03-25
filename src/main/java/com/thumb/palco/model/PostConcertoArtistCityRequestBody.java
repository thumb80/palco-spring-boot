package com.thumb.palco.model;

public class PostConcertoArtistCityRequestBody {

    public String artist;
    public String city;

    public PostConcertoArtistCityRequestBody() {
    }

    public PostConcertoArtistCityRequestBody(String artist, String city) {
        this.artist = artist;
        this.city = city;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
