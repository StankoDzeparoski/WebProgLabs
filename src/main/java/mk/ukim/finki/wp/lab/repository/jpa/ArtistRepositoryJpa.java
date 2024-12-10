package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


//    public Song addSongToArtist(Artist artist, Song song){
//        DataHolder.artists.removeIf(art -> art.getSongs().contains(song));
//        artist.getSongs().add(song);
//        return song;
//    }
@Repository
public interface ArtistRepositoryJpa extends JpaRepository<Artist, Long> {
    @Query("SELECT a FROM Artist a WHERE LOWER(a.firstName) LIKE LOWER(CONCAT('%', :name, '%')) OR LOWER(a.lastName) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Artist> search(String name);
    Optional<Artist> findById(long id);

}
