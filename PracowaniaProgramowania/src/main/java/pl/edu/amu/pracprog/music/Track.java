package pl.edu.amu.pracprog.music;

import java.util.List;

public class Track {
    int lengthInSeconds;
    int trackNumber;

    String title;
    String lyrics;

    public Track( int trackNumber, String title, int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
        this.trackNumber = trackNumber;
        this.title = title;
    }

    List<Artist> authors;
    List<Artist> performers;

    public void addPerformer(Artist performer){
        performers.add(performer);
    }

    public void addAuthor(Artist author){
        authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }


}
