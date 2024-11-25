package mk.ukim.finki.wp.lab.repository;

import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {
    public List<Song> findAll(){
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(String id){
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(id)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song){
        song.getPerformers().add(artist);
        return artist;
    }

    public Song Save(Song newSong){
        if(newSong.getTrackId().isEmpty()){
            return null;
        }
        DataHolder.songs.removeIf(song -> song.getTrackId().equals(newSong.getTrackId()));
        DataHolder.songs.add(newSong);
        return newSong;
    }

    public void delete(String id){
        if(id.isEmpty())
            return;
        DataHolder.songs.removeIf(song -> song.getTrackId().equals(id));
    }

}
