package com.stackroute.muzix.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter

public class Track {

    @Id
    @GeneratedValue
    private int id;
    private int duration, year;
    private String trackname, artist, genre, album, language;

    public Track(){

    }

    public Track(int duration,
                 int year,
                 String trackname,
                 String artist,
                 String genre,
                 String album,
                 String language) {


        this.duration = duration;
        this.year = year;
        this.trackname = trackname;
        this.artist = artist;
        this.genre = genre;
        this.album = album;
        this.language = language;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getDuration() {
//        return duration;
//    }
//
//    public void setDuration(int duration) {
//        this.duration = duration;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public String getTrackname() {
//        return trackname;
//    }
//
//    public void setTrackname(String trackname) {
//        this.trackname = trackname;
//    }
//
//    public String getArtist() {
//        return artist;
//    }
//
//    public void setArtist(String artist) {
//        this.artist = artist;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getAlbum() {
//        return album;
//    }
//
//    public void setAlbum(String album) {
//        this.album = album;
//    }
//
//    public String getLanguage() {
//        return language;
//    }
//
//    public void setLanguage(String language) {
//        this.language = language;
//    }

    @Override
    public String toString() {
        return "Track: " +
                "id=" + id +
                ", duration=" + duration +
                ", year=" + year +
                ", trackname='" + trackname + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", album='" + album + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
