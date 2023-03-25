package com.thumb.palco.controller;

import com.thumb.palco.model.*;
import com.thumb.palco.repository.ConcertiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConcertiController {

    @Autowired
    ConcertiRepository concertiRepository;

    @GetMapping(value = "/getconcerti",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcerti() {
        return concertiRepository.findAll();
    }

    @PostMapping(value = "/getconcertiforartist", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiArtist(@RequestBody Artist artist) {
        return concertiRepository.findByArtist(artist.artist);
    }

    @PostMapping(value = "/getconcertiforcity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiCity(@RequestBody City city) {
        return concertiRepository.findByCity(city.city);
    }

    @PostMapping(value = "/getconcertifortime", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiTime(@RequestBody Time time) {
        return concertiRepository.findByTime(time.time);
    }

    @PostMapping(value = "/getconcertiforartistandcity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertoArtistCity(@RequestBody PostConcertoArtistCityRequestBody requestBody) {
        return concertiRepository.findByArtistCity(requestBody.artist, requestBody.city);
    }

    @PostMapping(value = "/getconcertiforartistandtime", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertoArtistTime(@RequestBody PostConcertoArtistTimeRequestBody requestBody) {
        return concertiRepository.findByArtistTime(requestBody.artist, requestBody.time);
    }

    @PostMapping(value = "/insertconcerto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer insertElement(@RequestBody PostConcertoInsertRequestBody requestBody) {
        return concertiRepository.putConcert(requestBody.artist, requestBody.place, requestBody.city, requestBody.time);
    }

    @PostMapping(value = "/deleteconcerto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer deleteElement(@RequestBody PostConcertoArtistTimeRequestBody requestBody) {
        return concertiRepository.deleteConcert(requestBody.artist, requestBody.time);
    }

    @PostMapping(value = "/updateconcertoplace", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateConcertPlace(@RequestBody PostConcertoArtistTimePlaceRequestBody requestBody) {
        return concertiRepository.updateConcertPlace(requestBody.place, requestBody.artist, requestBody.time);
    }

    @PostMapping(value = "/updateconcertocity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateConcertCity(@RequestBody PostConcertoArtistTimeCityRequestBody requestBody) {
        return concertiRepository.updateConcertCity(requestBody.city, requestBody.artist, requestBody.time);
    }
}
