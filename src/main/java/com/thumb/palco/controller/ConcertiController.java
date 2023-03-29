package com.thumb.palco.controller;

import com.thumb.palco.dto.Concerto;
import com.thumb.palco.model.*;
import com.thumb.palco.service.ConcertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
public class ConcertiController {

    @Autowired
    ConcertoService concertoService;

    @RequestMapping(method = RequestMethod.GET, value = "/getconcerti",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcerti() {
        return concertoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getartists", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getArtists() {
        return concertoService.findArtists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getcities", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getCities() {
        return concertoService.findCities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertiartist/{artist}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiArtist(@PathVariable String artist) {
        return concertoService.findByArtist(artist);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcerticity/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiCity(@PathVariable String city) {
        return concertoService.findByCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertitime/{time}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertiTime(@PathVariable String time) {
        return concertoService.findByTime(time);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertiartistcity/{artist}/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertoArtistCity(@PathVariable String artist,@PathVariable String city) {
        return concertoService.findByArtistCity(artist, city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertitimeartist/{time}/{artist}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> postConcertoArtistTime(@PathVariable String time,@PathVariable String artist) {
        return concertoService.findByArtistTime(time, artist);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/insertconcerto", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer insertElement(@RequestBody PutConcertoRequestBody requestBody) {
        return concertoService.putConcert(requestBody.artist, requestBody.place, requestBody.city, requestBody.time);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteconcerto/{artist}/{time}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer deleteElement(@PathVariable String artist, @PathVariable String time) {
        return concertoService.deleteConcert(artist, time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateconcertoplace", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateConcertPlace(@RequestBody PatchPlaceRequestBody requestBody) {
        return concertoService.updateConcertPlace(requestBody.place, requestBody.artist, requestBody.time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateconcertocity", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateConcertCity(@RequestBody PatchCityRequestBody requestBody) {
        return concertoService.updateConcertCity(requestBody.city, requestBody.artist, requestBody.time);
    }
}
