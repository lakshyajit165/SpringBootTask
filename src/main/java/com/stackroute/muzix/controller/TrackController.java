package com.stackroute.muzix.controller;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TrackController {
    @Autowired
   // @Qualifier("dummy")
    ServiceManager serviceManager;



    HashMap<String, Object> responseObject;



    // Create
    @PostMapping(path="/track", consumes={"application/json"})
    public ResponseEntity<HashMap<String, Object>> addTrack(@RequestBody Track track) throws TrackAlreadyExistsException {

        Track t = serviceManager.addTrack(track);

        responseObject = new HashMap<>();
        responseObject.put("result", t);
        responseObject.put("msg", "Track Added!");
        responseObject.put("error", "false");

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    // Read
    @GetMapping(path="/tracks")
    public ResponseEntity<HashMap<String, Object>> getTracks(){

        List<Track> t = serviceManager.getTracks();

        responseObject = new HashMap<>();
        responseObject.put("result", t);
        responseObject.put("msg", "Success!");
        responseObject.put("error", "false");


        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
//
    // Update
    @PutMapping(path="/track/{tid}", consumes={"application/json"})
    public ResponseEntity<HashMap<String, Object>> saveOrUpdateTrack(@RequestBody Track track){

        String msg = serviceManager.saveOrUpdateTrack(track);

        responseObject = new HashMap<>();
        responseObject.put("result", msg);
        responseObject.put("msg", "Edit Successful!");
        responseObject.put("error", "false");

        return new ResponseEntity<>(responseObject, HttpStatus.OK);

    }
//
    // Delete
    @DeleteMapping("/track/{tid}")
    public ResponseEntity<HashMap<String, Object>> deleteTrack(@PathVariable int tid){

        String msg = serviceManager.deleteTrack(tid);

        responseObject = new HashMap<>();
        responseObject.put("result", msg);
        responseObject.put("msg", "Success!");
        responseObject.put("error", "false");

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }

    // Get tracks by year
    @GetMapping("/tracks/{year}")
    public ResponseEntity<HashMap<String, Object>> getTracksByYear(@PathVariable int year) throws TrackNotFoundException {
        List<Track> t = serviceManager.getTracksByYear(year);

        responseObject = new HashMap<>();
        responseObject.put("result", t);
        responseObject.put("msg", "Success!");
        responseObject.put("error", "false");

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }
//
    // Get Tracks by language
    @GetMapping("/tracks/language/{language}")
    public ResponseEntity<HashMap<String, Object>> getTracksByLanguage(@PathVariable String language) throws TrackNotFoundException {
        List<Track> t = serviceManager.getTracksByLanguage(language);

        responseObject = new HashMap<>();
        responseObject.put("result", t);
        responseObject.put("msg", "Success!");
        responseObject.put("error", "false");

        return new ResponseEntity<>(responseObject, HttpStatus.OK);
    }



}
