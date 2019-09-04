package com.stackroute.muzix.service;

import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;

import org.springframework.stereotype.Component;

import java.util.List;



public interface ServiceManager {

    public Track addTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getTracks();

    public String saveOrUpdateTrack(Track track);

    public String deleteTrack(int tid);

    public List<Track> getTracksByYear(int year) throws TrackNotFoundException;

    public List<Track> getTracksByLanguage(String language) throws TrackNotFoundException;
}
