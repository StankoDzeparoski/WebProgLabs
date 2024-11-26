package mk.ukim.finki.wp.lab.model;

//String trackId,
//String title,
//String genre,
//int releaseYear и
//List <Artist> performers

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

//@Entity
@Data
public class Song {
    private Long id;
    private String trackId;
    private String title;
    private String genre;
    private int releaseYear;
    private List<Artist> performers;
//    @OneToOne
    private Album album;

    public Song(String trackId, String title, String genre, int releaseYear, List<Artist> performers, Album album) {
        this.id = (long)(Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(String trackId, String title, String genre, int releaseYear, Album album) {
        this.id = (long)(Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<Artist>();
        this.album = album;
    }


}
