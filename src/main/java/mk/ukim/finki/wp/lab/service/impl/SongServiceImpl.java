package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        if(artist == null || song == null)
            return null;

        songRepository.addArtistToSong(artist, song);
        return artist;
    }

    @Override
    public Song findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId).orElse(null);
    }

    @Override
    public Song Save(String trackId, String title, String genre, int releaseYear, List<Artist> performers) {
        if(trackId == null)
            return null;
        Song newSong = new Song(trackId, title, genre, releaseYear, performers);
        songRepository.Save(newSong);
        return newSong;
    }

    @Override
    public void delete(String id) {
        if(id.isEmpty())
            return;
        songRepository.delete(id);
    }
}
