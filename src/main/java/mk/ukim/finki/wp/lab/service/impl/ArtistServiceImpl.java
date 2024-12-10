package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
//import mk.ukim.finki.wp.lab.repository.impl.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.jpa.ArtistRepositoryJpa;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepositoryJpa artistRepositoryJpa;

    public ArtistServiceImpl(ArtistRepositoryJpa artistRepositoryJpa) {
        this.artistRepositoryJpa = artistRepositoryJpa;
    }

    @Override
    public List<Artist> listArtists() {
        if(artistRepositoryJpa.findAll().isEmpty()) {
            return null;
        }
        return artistRepositoryJpa.findAll();
    }

    @Override
    public Artist ArtistfindById(Long id) {
        return artistRepositoryJpa.findById(id).orElse(null);
    }

    public Song addSongToArtist(Artist artist, Song song) {
        if(artist == null || song == null)
            return null;

        if(artist.getSongs().contains(song)){
            artist.getSongs().remove(song);
        }
//        artistRepositoryJpa.findAll().removeIf(art -> art.getSongs().contains(song));
        artist.getSongs().add(song);
        artistRepositoryJpa.save(artist);
        return song;
    }

    @Override
    public Artist Save(Long id, String firstName, String lastName, String bio) {
        if(id == null){
            return null;
        }
        Artist artist = new Artist(id, firstName, lastName, bio);
        artistRepositoryJpa.save(artist);
        return artist;
    }

    @Override
    public void delete(Long id) {
        if(id == null)
            return;
        artistRepositoryJpa.deleteById(id);
    }

    @Override
    public List<Artist> filterBySearch(String nameArtist) {
        return artistRepositoryJpa.search(nameArtist);
    }

//    private final ArtistRepository artistRepository;
//
//    public ArtistServiceImpl(ArtistRepository artistRepository) {
//        this.artistRepository = artistRepository;
//    }
//
//    @Override
//    public List<Artist> listArtists() {
//        if(artistRepository.findAll().isEmpty()) {
//            return null;
//        }
//        return artistRepository.findAll();
//    }
//
//    @Override
//    public Artist ArtistfindById(Long id) {
//        return artistRepository.findById(id).orElse(null);
//    }
//
//    public Song addSongToArtist(Artist artist, Song song) {
//        if(artist == null || song == null)
//            return null;
//
//        artistRepository.addSongToArtist(artist, song);
//        return song;
//    }
//
//    @Override
//    public Artist Save(Long id, String firstName, String lastName, String bio) {
//        if(id == null){
//            return null;
//        }
//        Artist artist = new Artist(id, firstName, lastName, bio);
//        artistRepository.Save(artist);
//        return artist;
//    }
//
//    @Override
//    public void delete(Long id) {
//        if(id == null)
//            return;
//        artistRepository.delete(id);
//    }
//
//    @Override
//    public List<Artist> filterBySearch(String nameArtist) {
//        return artistRepository.filterBySearch(nameArtist);
//    }
}
