package mk.ukim.finki.wp.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artists = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();

    @PostConstruct
    public void init(){
        this.artists.add(new Artist((long)1, "John", "Stewart", "Britain"));
        this.artists.add(new Artist((long)2, "Brad", "Stewart", "Britain"));
        this.artists.add(new Artist((long)3, "Daemon", "Stewart", "Britain"));
        this.artists.add(new Artist((long)4, "Richard", "Stewart", "Britain"));
        this.artists.add(new Artist((long)5, "Kon", "Stewart", "Britain"));
        this.songs.add(new Song("1", "SampleTitle1", "Pop", 2049, new ArrayList<>()));
        this.songs.add(new Song("2", "SampleTitle2", "Rap", 1910, new ArrayList<>()));
        this.songs.add(new Song("3", "SampleTitle3", "Jazz", 1921, new ArrayList<>()));
        this.songs.add(new Song("4", "SampleTitle4", "Rap", 1932, new ArrayList<>()));
        this.songs.add(new Song("5", "SampleTitle5", "Rap", 1943, new ArrayList<>()));

    }
}