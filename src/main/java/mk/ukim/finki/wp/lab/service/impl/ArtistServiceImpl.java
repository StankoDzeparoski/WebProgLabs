package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> listArtists() {
        if(artistRepository.findAll().isEmpty()) {
            return null;
        }
        return artistRepository.findAll();
    }

    @Override
    public Artist ArtistfindById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Song addSongToArtist(Artist artist, Song song) {
        if(artist == null || song == null)
            return null;

        artistRepository.addSongToArtist(artist, song);
        return song;
    }

    @Override
    public Artist Save(Long id, String firstName, String lastName, String bio) {
        if(id == null){
            return null;
        }
        Artist artist = new Artist(id, firstName, lastName, bio);
        artistRepository.Save(artist);
        return artist;
    }

    @Override
    public void delete(Long id) {
        if(id == null)
            return;
        artistRepository.delete(id);
    }
}
