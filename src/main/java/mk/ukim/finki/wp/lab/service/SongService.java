package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    Song Save(String trackId, String title, String genre, int releaseYear, List<Artist> performers);
    void delete(String id);
}
