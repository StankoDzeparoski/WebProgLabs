package mk.ukim.finki.wp.lab.web.controller;

import jakarta.servlet.http.HttpSession;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ArtistController {

    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping("/Artist")
    public String getArtistPage(@RequestParam(required = false) String radioSong, @RequestParam(required = false) String search,
                                 Model model) {
        model.addAttribute("songId", radioSong);
        model.addAttribute("songs", songService.listSongs());

        if (search != null && !search.isEmpty()){
            model.addAttribute("artists", artistService.filterBySearch(search));
        }
        else model.addAttribute("artists", artistService.listArtists());
        return "artistsList";
    }

    @PostMapping("/Artist")
    public String assignArtistToSong(@RequestParam Long radioArtist,
                                     @RequestParam String radioSong) {
        Artist artist = artistService.ArtistfindById(radioArtist);
        Song song = songService.findByTrackId(radioSong);

        songService.addArtistToSong(artist, song);
        artistService.addSongToArtist(artist, song);

        return "redirect:/songDetails?TrackId=" + radioSong;
    }

}
