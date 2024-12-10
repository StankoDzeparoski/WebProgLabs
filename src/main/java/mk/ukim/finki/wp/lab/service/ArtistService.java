package mk.ukim.finki.wp.lab.service;

//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> listArtists();
    Artist ArtistfindById(Long id);
    Song addSongToArtist(Artist artist, Song song);
    Artist Save(Long id, String firstName, String lastName, String bio);
    void delete(Long id);
    List<Artist> filterBySearch(String nameArtist);
}
