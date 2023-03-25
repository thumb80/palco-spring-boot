package com.thumb.palco.model;

public class PostConcertoInsertRequestBody {

    public String artist;
    public String place;
    public String city;
    public String time;

    public PostConcertoInsertRequestBody() {
    }

    public PostConcertoInsertRequestBody(String artist, String place, String city, String time) {
        this.artist = artist;
        this.place = place;
        this.city = city;
        this.time = time;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
