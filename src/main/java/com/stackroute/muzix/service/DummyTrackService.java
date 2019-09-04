package com.stackroute.muzix.service;

import com.stackroute.muzix.dao.TrackDao;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("prod")
@Service("dummy")
public class DummyTrackService implements ServiceManager{

    @Autowired
    TrackDao trackDao;

    public Track addTrack(Track track) throws TrackAlreadyExistsException {
        List<Track> t = trackDao.findTrackByName(track.getTrackname());
        if(t.size() != 0){
            throw new TrackAlreadyExistsException("Track "+track.getTrackname()+" already exists!");

        }
        trackDao.save(track);
        return track;
    }

    public List<Track> getTracks(){
        System.out.println("IN Dummy Service!");
        return trackDao.findAll();
    }

    public String saveOrUpdateTrack(Track track){
        trackDao.save(track);
        return "Track "+ track.getTrackname()+ " Updated!";
    }

    public String deleteTrack(int tid){
        Track t = trackDao.getOne(tid);

        trackDao.delete(t);

        return "Track Deleted!";
    }

    public List<Track> getTracksByYear(int year) throws TrackNotFoundException {
        List<Track> t = trackDao.findTrackByYear(year);
        if(t.size() == 0)
            throw new TrackNotFoundException("No tracks found for the year "+year+"!");
        return t;
    }

    public List<Track> getTracksByLanguage(String language) throws TrackNotFoundException {
        List<Track> t = trackDao.findTrackByLanguage(language);
        if(t.size() == 0)
            throw new TrackNotFoundException("No tracks found for "+language+" language!");
        return t;
    }
}
