package com.thumb.palco.controller;

import com.thumb.palco.dto.*;
import com.thumb.palco.model.Concerto;
import com.thumb.palco.service.ConcertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConcertiController {

    @Autowired
    ConcertoService concertoService;

    @RequestMapping(method = RequestMethod.GET, value = "/events",  produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcerti() {
        return concertoService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/artists", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getArtists() {
        return concertoService.findArtists();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<String> getCities() {
        return concertoService.findCities();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/artist/{artist}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiArtist(@PathVariable String artist) {
        return concertoService.findByArtist(artist);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/city/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiCity(@PathVariable String city) {
        return concertoService.findByCity(city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertitime/{time}", produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin(origins = "https://palco.mywire.org")
    public List<Concerto> getConcertiTime(@PathVariable String time) {
        return concertoService.findByTime(time);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertiartistcity/{artist}/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiArtistCity(@PathVariable String artist, @PathVariable String city) {
        return concertoService.findByArtistCity(artist, city);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getconcertitimeartist/{time}/{artist}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiArtistTime(@PathVariable String time, @PathVariable String artist) {
        return concertoService.findByArtistTime(time, artist);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getconcertimese", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiByMonth(@RequestBody DateSearchDTO dateSearchDTO) {
        return concertoService.findByMonth(dateSearchDTO);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/getconcertimesecity", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Concerto> getConcertiByMonthCity(@RequestBody DateCitySearchDTO dateCitySearchDTO) {
        return concertoService.findByMonthCity(dateCitySearchDTO);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/insertitem", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer insertElement(@RequestBody ConcertoDTO requestBody) {
        return concertoService.putConcert(requestBody.artist, requestBody.place, requestBody.city, requestBody.time);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteitem", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer deleteElement(@RequestBody ConcertoDTO requestBody) {
        return concertoService.deleteElement(requestBody.artist, requestBody.place, requestBody.city, requestBody.time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateitemartist", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateElementArtist(@RequestBody ConcertoDTO requestBody) {
        return concertoService.updateElementArtist(requestBody.artist, requestBody.place, requestBody.city,requestBody.time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateitemplace", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateElementPlace(@RequestBody ConcertoDTO requestBody) {
        return concertoService.updateElementPlace(requestBody.artist, requestBody.place, requestBody.city,requestBody.time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateitemcity", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateElementCity(@RequestBody ConcertoDTO requestBody) {
        return concertoService.updateElementCity(requestBody.artist, requestBody.place, requestBody.city,requestBody.time);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/updateitemtime", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Integer updateElementTime(@RequestBody ConcertoDTO requestBody) {
        return concertoService.updateElementTime(requestBody.artist, requestBody.place, requestBody.city,requestBody.time);
    }
}
