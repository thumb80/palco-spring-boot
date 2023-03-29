package com.thumb.palco.service;

import com.thumb.palco.dto.Concerto;
import com.thumb.palco.repository.ConcertiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConcertoService {

    @Autowired
    ConcertiRepository concertiRepository;

    public List<Concerto> findAll() {
        return concertiRepository.findAll();
    }

    public List<String> findArtists() {
        return concertiRepository.findArtists();
    }

    public List<String> findCities() {
        return concertiRepository.findCities();
    }

    public List<Concerto> findByArtist(String artist) {
        return concertiRepository.findByArtist(artist);
    }

    public List<Concerto> findByCity(String city) {
        return concertiRepository.findByCity(city);
    }

    public List<Concerto> findByTime(String time) {
        return concertiRepository.findByTime(time);
    }

    public List<Concerto> findByArtistCity(String artist, String time) {
        return concertiRepository.findByArtistCity(artist, time);
    }

    public List<Concerto> findByArtistTime(String time, String artist) {
        return concertiRepository.findByArtistTime(time, artist);
    }

    public Integer putConcert(String artist, String place, String city, String time) {
        return concertiRepository.putConcert(artist, place, city, time);
    }

    public Integer deleteConcert(String artist, String time) {
        return concertiRepository.deleteConcert(artist, time);
    }

    public Integer updateConcertPlace(String place, String artist, String time) {
        return concertiRepository.updateConcertPlace(place, artist, time);
    }

    public Integer updateConcertCity(String city, String artist, String time) {
        return concertiRepository.updateConcertCity(city, artist, time);
    }

}
