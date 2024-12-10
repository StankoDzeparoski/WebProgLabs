package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepositoryJpa extends JpaRepository<Song, Long> {
    Optional<Song> findByTrackId(String trackId);
    void deleteByTrackId(String trackId);
//    @Query(value = "select * from ")
//    Artist addArtistToSong(Artist artist, Song song);
}
