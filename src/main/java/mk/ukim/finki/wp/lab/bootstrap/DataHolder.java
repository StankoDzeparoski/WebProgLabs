//package mk.ukim.finki.wp.lab.bootstrap;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.model.Artist;
//import mk.ukim.finki.wp.lab.model.Song;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Component
//public class DataHolder {
//    public static List<Artist> artists = new ArrayList<>();
//    public static List<Song> songs = new ArrayList<>();
//    public static List<Album> albums = new ArrayList<>();
//
//    @PostConstruct
//    public void init(){
//        this.artists.add(new Artist( "John", "Stewart", "Britain"));
//        this.artists.add(new Artist( "Brad", "Stewart", "Canada"));
//        this.artists.add(new Artist( "Daemon", "Stewart", "Britain"));
//        this.artists.add(new Artist( "Richard", "Stewart", "Britain"));
//        this.artists.add(new Artist( "Kon", "Stewart", "Britain"));
//
//        this.albums.add(new Album("POP ALBUM", "Pop", "2049"));
//        this.albums.add(new Album("RAP ALBUM", "Rap", "2020"));
//        this.albums.add(new Album("POP ALBUM2", "Pop", "2024"));
//        this.albums.add(new Album("JAZZ ALBUM", "Jazz", "2023"));
//        this.albums.add(new Album("POP ALBUM3", "Pop", "2024"));
//
//        this.songs.add(new Song("1", "SampleTitle1", "Pop", 2049, new ArrayList<>(), albums.get(0)));
//        this.songs.add(new Song("2", "SampleTitle2", "Rap", 2020, new ArrayList<>(), albums.get(1)));
//        this.songs.add(new Song("3", "SampleTitle3", "Jazz", 2023, new ArrayList<>(), albums.get(3)));
//        this.songs.add(new Song("4", "SampleTitle4", "Pop", 2024, new ArrayList<>(), albums.get(2)));
//        this.songs.add(new Song("5", "SampleTitle5", "Pop", 2024, new ArrayList<>(), albums.get(4)));
//
//    }
//}