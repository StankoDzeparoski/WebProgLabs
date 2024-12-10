//package mk.ukim.finki.wp.lab.repository.impl;
//
//import mk.ukim.finki.wp.lab.bootstrap.DataHolder;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class ArtistRepository {
//
//    public List<Artist> findAll(){
//        return DataHolder.artists;
//    }
//
//    public Optional<Artist> findById(Long id){
//        return DataHolder.artists.stream().filter(artist -> artist.getId().equals(id)).findFirst();
//    }
//
//    public Artist Save(Artist artist){
//        DataHolder.artists.removeIf(art -> art.getId().equals(artist.getId()));
//        DataHolder.artists.add(artist);
//        return artist;
//    }
//
//    public Song addSongToArtist(Artist artist, Song song){
//        DataHolder.artists.removeIf(art -> art.getSongs().contains(song));
//        artist.getSongs().add(song);
//        return song;
//    }
//
//    public void delete(Long id){
//        DataHolder.artists.removeIf(art -> art.getId().equals(id));
//    }
//
//    public List<Artist> filterBySearch(String nameArtist){
//        List<Artist> filteredArtists = new ArrayList<>();
//
//        if(nameArtist != null){
//            filteredArtists = DataHolder.artists.stream().filter(i -> i.getFirstName().toLowerCase().contains(nameArtist.toLowerCase())
//                    || i.getLastName().toLowerCase().contains(nameArtist.toLowerCase())
//                    || i.getBio().toLowerCase().contains(nameArtist.toLowerCase())).toList();
//
//        }
//        return filteredArtists;
//    }
//}
