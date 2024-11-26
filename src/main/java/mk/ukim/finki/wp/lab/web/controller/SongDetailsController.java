package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.service.ArtistService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SongDetailsController {

    private final SongService songService;
    private final ArtistService artistService;

    public SongDetailsController(SongService songService, ArtistService artistService) {
        this.songService = songService;
        this.artistService = artistService;
    }

    @GetMapping("/songDetails")
    public String getSongDetails(@RequestParam String TrackId, Model model) {
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("artists", artistService.listArtists());
        model.addAttribute("selectedSong", songService.findByTrackId(TrackId));

        return "songDetails";
    }
}
