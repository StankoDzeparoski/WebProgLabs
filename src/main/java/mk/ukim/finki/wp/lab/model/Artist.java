package mk.ukim.finki.wp.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//Long id,
//String firstName,
//String lastName и
//String bio
@Data
public class Artist {
    private Long id;
    private String firstName;
    private String lastName;
    private String bio;
    private List<Song> songs = new ArrayList<>();

    public Artist(Long id, String firstName, String lastName, String bio) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
    }
}
