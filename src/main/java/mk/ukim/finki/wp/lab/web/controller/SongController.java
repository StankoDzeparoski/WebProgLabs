package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.service.AlbumService;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SongController {

    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping("/songs")
    public String getSongsPage(@RequestParam(required = false) String error, Model model){
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Song> songs = this.songService.listSongs();
        model.addAttribute("songs", songs);
        return "listSongs";
    }

    @PostMapping("/songs")
    public String chooseSong(@RequestParam String radioSong){
        return ("redirect:/Artist?radioSong=" + radioSong);
    }

    @PostMapping("/songs/edit/{id}")
    public String editSong(){
        return ("redirect:/?");
    }

    @GetMapping("/songs/delete/{id}")
    public String deleteSong(@PathVariable Long id) {
        this.songService.delete(id);
        return "redirect:/songs";
    }

    @GetMapping("/songs/add-form")
    public String addSongPage(Model model){
        List<Album> albums = this.albumService.findAll();
        model.addAttribute("albums", albums);

        return "add-song";
    }

    @PostMapping("/songs/add")
    public String saveSong(@RequestParam String title,
                              @RequestParam String trackId,
                              @RequestParam String genre,
                              @RequestParam Integer releaseYear,
                              @RequestParam Long album){
        this.songService.Save(trackId,title, genre, releaseYear, album);
        return "redirect:/songs";

    }

    @GetMapping("/songs/edit-form/{id}")
    public String editSong(@PathVariable Long id, Model model){
        if(this.songService.findBySongId(id).isPresent()) {
            Song song = this.songService.findBySongId(id).get();
            List<Album> albums = this.albumService.findAll();
            model.addAttribute("albums", albums);
            model.addAttribute("song", song);
            return "add-song";
        }

        return ("redirect:/songs?error=SongNotFound");
    }

}
