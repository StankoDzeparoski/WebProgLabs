package mk.ukim.finki.wp.lab.service;

//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Genre;
import mk.ukim.finki.wp.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findByTrackId(String trackId);
    Song Save(String trackId, String title, Genre genre, int releaseYear, Long AlbumId);
    void delete(Long id);
    void deleteByTrackId(String trackId);
    Optional<Song> findBySongId(Long songId);
    List<Song> findAllByAlbum_Id(Long albumId);
}
