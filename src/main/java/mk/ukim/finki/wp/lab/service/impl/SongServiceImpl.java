package mk.ukim.finki.wp.lab.service.impl;

import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.impl.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.impl.SongRepository;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJpa;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepositoryJpa;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepositoryJpa songRepositoryJpa;
    private final SongRepository songRepository;
    private final AlbumRepositoryJpa albumRepositoryJpa;

    public SongServiceImpl(SongRepositoryJpa songRepositoryJpa, SongRepository songRepository, AlbumRepositoryJpa albumRepositoryJpa) {
        this.songRepositoryJpa = songRepositoryJpa;
        this.songRepository = songRepository;
        this.albumRepositoryJpa = albumRepositoryJpa;
    }

    @Override
    public List<Song> listSongs() {
        return songRepositoryJpa.findAll();
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
        return songRepositoryJpa.findByTrackId(trackId).orElse(null);
    }

    @Override
    public Song Save(String trackId, String title, String genre, int releaseYear, Long AlbumId) {
        if(trackId == null)
            return null;

        Album album = albumRepositoryJpa.findAll().stream().filter(i -> i.getId().equals(AlbumId)).findFirst().orElse(null);
        deleteByTrackId(trackId);
        Song newSong = new Song(trackId, title, genre, releaseYear, album);
        songRepositoryJpa.save(newSong);
        return newSong;
    }
    @Transactional
    @Override
    public void delete(Long id) {
        if(id == null)
            return;
        songRepositoryJpa.deleteById(id);
    }
    @Transactional
    @Override
    public void deleteByTrackId(String trackId) {
        songRepositoryJpa.deleteByTrackId(trackId);
    }

    @Override
    public Optional<Song> findBySongId(Long songId) {
        return songRepositoryJpa.findById(songId);
    }


//
//    private final SongRepository songRepository;
//    private final AlbumRepository albumRepository;
//
//    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
//        this.songRepository = songRepository;
//        this.albumRepository = albumRepository;
//    }
//
//    @Override
//    public List<Song> listSongs() {
//        return songRepository.findAll();
//    }
//
//    @Override
//    public Artist addArtistToSong(Artist artist, Song song) {
//        if(artist == null || song == null)
//            return null;
//
//        songRepository.addArtistToSong(artist, song);
//        return artist;
//    }
//
//    @Override
//    public Song findByTrackId(String trackId) {
//        return songRepository.findByTrackId(trackId).orElse(null);
//    }
//
//    @Override
//    public Song Save(String trackId, String title, String genre, int releaseYear, Long AlbumId) {
//        if(trackId == null)
//            return null;
//        Album album = albumRepository.findAll().stream().filter(i -> i.getId().equals(AlbumId)).findFirst().orElse(null);
//        Song newSong = new Song(trackId, title, genre, releaseYear, album);
//        songRepository.Save(newSong);
//        return newSong;
//    }
//
//    @Override
//    public void delete(Long id) {
//        if(id == null)
//            return;
//        songRepository.delete(id);
//    }
//
//    @Override
//    public Optional<Song> findBySongId(Long songId) {
//        return songRepository.findBySongId(songId);
//    }
}
