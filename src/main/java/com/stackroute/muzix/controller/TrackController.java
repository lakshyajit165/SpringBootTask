package com.stackroute.muzix.controller;

import com.stackroute.muzix.dao.TrackDao;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {

    @Autowired
    TrackDao trackDao;

    // Create
    @PostMapping(path="/track", consumes={"application/json"})
    public Track addAlien(@RequestBody Track track) throws TrackAlreadyExistsException {
        List<Track> t = trackDao.findTrackByName(track.getTrackname());
        if(t.size() != 0){
            throw new TrackAlreadyExistsException("Track "+track.getTrackname()+" already exists!");
        }
        trackDao.save(track);
        return track;
    }

    // Read
    @GetMapping(path="/tracks")
    public List<Track> getTracks(){

        return trackDao.findAll();

    }

    // Update
    @PutMapping(path="/track/{tid}", consumes={"application/json"})
    public String saveOrUpdateTrack(@RequestBody Track track){


        trackDao.save(track);

        return "Track "+ track.getTrackname()+ " Updated!";

    }

    // Delete
    @DeleteMapping("/track/{tid}")
    public String deleteTrack(@PathVariable int tid){
        Track t = trackDao.getOne(tid);

        trackDao.delete(t);

        return "Deleted!";
    }

    // Get tracks by year
    @GetMapping("/tracks/{year}")
    public List<Track> getTracksByYear(@PathVariable int year) throws TrackNotFoundException {
        List<Track> t = trackDao.findTrackByYear(year);
        if(t.size() == 0)
            throw new TrackNotFoundException("No tracks found for the year "+year+"!");
        return t;
    }

    // Get Tracks by language
    @GetMapping("/tracks/language/{language}")
    public List<Track> getTracksByLanguage(@PathVariable String language){
        List<Track> t = trackDao.findTrackByLanguage(language);
        return t;
    }



}
