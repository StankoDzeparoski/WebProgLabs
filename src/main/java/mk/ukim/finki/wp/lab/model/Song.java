package mk.ukim.finki.wp.lab.model;

//String trackId,
//String title,
//String genre,
//int releaseYear и
//List <Artist> performers

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String trackId;
    private String title;
    @OneToOne
    private Genre genre;
    private int releaseYear;
    @ManyToMany
    private List<Artist> performers;
    @ManyToOne
    private Album album;

    public Song(String trackId, String title, Genre genre, int releaseYear, List<Artist> performers, Album album) {
//        this.id = (long)(Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(Long id, String trackId, String title, String genreName, String genreDesc,
                int releaseYear, List<Artist> performers, Album album) {
        this.id = id;
        this.trackId = trackId;
        this.title = title;
        this.genre = new Genre(genreName,genreDesc);
        this.releaseYear = releaseYear;
        this.performers = performers;
        this.album = album;
    }

    public Song(String trackId, String title, String genreName, String genreDesc, int releaseYear, Album album) {
//        this.id = (long)(Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = new Genre(genreName,genreDesc);
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<Artist>();
        this.album = album;
    }

    public Song(String trackId, String title, Genre genre, int releaseYear, Album album) {
//        this.id = (long)(Math.random() * 1000);
        this.trackId = trackId;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.performers = new ArrayList<Artist>();
        this.album = album;
    }


    public Song() {

    }
}
