package pl.edu.amu.pracprog.music;

import java.util.ArrayList;
import java.util.List;

public class Album {
    String title;

    int year;
    List<Track> tracks;

    public Album(String title, int year) {
        this.title = title;
        this.year = year;
        tracks = new ArrayList<Track>();
    }

    public void addTrack(int i, Track track){
        tracks.add(i, track);
    }

    public void addTrack(Track track){
        tracks.add(track);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
