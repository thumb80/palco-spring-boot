package com.thumb.palco.service;

import com.thumb.palco.dto.DateCitySearchDTO;
import com.thumb.palco.model.Concerto;
import com.thumb.palco.dto.DateSearchDTO;
import com.thumb.palco.repository.ConcertiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    public List<Concerto> findByMonth(DateSearchDTO dateSearchDTO) {
        LocalDateTime mintime = LocalDateTime.of(dateSearchDTO.getStartDate(), LocalTime.of(0,0,0));
        LocalDateTime maxtime = LocalDateTime.of(dateSearchDTO.getEndDate(), LocalTime.of(0,0,0));
        return concertiRepository.findElementByMonth(mintime, maxtime);
    }

    public List<Concerto> findByMonthCity(DateCitySearchDTO dateCitySearchDTO) {
        LocalDateTime mintime = LocalDateTime.of(dateCitySearchDTO.getStartDate(), LocalTime.of(0,0,0));
        LocalDateTime maxtime = LocalDateTime.of(dateCitySearchDTO.getEndDate(), LocalTime.of(0,0,0));
        String city = dateCitySearchDTO.getCity();
        return concertiRepository.findElementByMonthCity(mintime, maxtime, city);
    }

    public Integer putConcert(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findId(artist, place, city, time);
        Concerto concerto = concertiRepository.findElement(id);
        if (concerto != null)
            return -1;
        else
            return concertiRepository.createElement(artist, place, city, time);
    }

    public Integer deleteElement(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findId(artist, place, city, time);
        return concertiRepository.deleteElement(id);
    }


    public Integer updateElementArtist(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findIdArtist(place, city, time);
        return concertiRepository.updateElementArtist(id, artist);
    }

    public Integer updateElementPlace(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findIdPlace(artist, city, time);
        return concertiRepository.updateElementPlace(id, place);
    }

    public Integer updateElementCity(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findIdCity(artist, place, time);
        return concertiRepository.updateElementCity(id, city);
    }

    public Integer updateElementTime(String artist, String place, String city, String time) {
        Integer id = concertiRepository.findIdTime(artist, place, city);
        return concertiRepository.updateElementTime(id, time);
    }
}
