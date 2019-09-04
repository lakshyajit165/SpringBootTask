package com.stackroute.muzix.dao;

import com.stackroute.muzix.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrackDao extends JpaRepository<Track, Integer> {

    @Query("from Track where year=?1")
    List<Track> findTrackByYear(int year);

    @Query("from Track where language=?1")
    List<Track> findTrackByLanguage(String language);

    @Query("from Track where trackname=?1")
    List<Track> findTrackByName(String name);
}
