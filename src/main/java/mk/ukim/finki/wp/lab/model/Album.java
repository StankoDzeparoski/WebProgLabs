package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.List;

@Data
public class Album {
    private Long id;
    private String name;
    private String genre;
    private String releaseYear;
    private List<Song> songs;

    public Album(String name, String genre, String releaseYear) {
        this.id = (long)(Math.random() * 1000);
        this.name = name;
        this.genre = genre;
        this.releaseYear = releaseYear;
    }
}
