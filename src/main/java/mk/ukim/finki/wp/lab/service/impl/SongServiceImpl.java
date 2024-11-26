package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.ArtistRepository;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
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
    public Song Save(String trackId, String title, String genre, int releaseYear, Long AlbumId) {
        if(trackId == null)
            return null;
        Album album = albumRepository.findAll().stream().filter(i -> i.getId().equals(AlbumId)).findFirst().orElse(null);
        Song newSong = new Song(trackId, title, genre, releaseYear, album);
        songRepository.Save(newSong);
        return newSong;
    }

    @Override
    public void delete(Long id) {
        if(id == null)
            return;
        songRepository.delete(id);
    }

    @Override
    public Optional<Song> findBySongId(Long songId) {
        return songRepository.findBySongId(songId);
    }
}
