//package mk.ukim.finki.wp.lab.web.servlet;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.ukim.finki.wp.lab.service.ArtistService;
//import mk.ukim.finki.wp.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//
//import java.io.IOException;
//
//@WebServlet(name = "ArtistServlet", urlPatterns = "/Artist")
//public class ArtistServlet extends HttpServlet {
//
//    private final SpringTemplateEngine templateEngine;
//    private final ArtistService artistService;
//    private final SongService songService;
//
//    public ArtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService){
//        this.templateEngine = templateEngine;
//        this.artistService = artistService;
//        this.songService = songService;
//    }
//
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        IWebExchange webExchange = JakartaServletWebApplication
//                .buildApplication(getServletContext())
//                .buildExchange(req, resp);
//
//        WebContext context = new WebContext(webExchange);
//
//        context.setVariable("songId", req.getParameter("radioSong"));
//        context.setVariable("songs", this.songService.listSongs());
//        context.setVariable("artists", this.artistService.listArtists());
//
//        this.templateEngine.process("artistsList.html", context, resp.getWriter());
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        songService.addArtistToSong(artistService.ArtistfindById(Long.valueOf(req.getParameter("radioArtist"))), songService.findByTrackId(req.getParameter("radioSong")));
//        artistService.addSongToArtist(artistService.ArtistfindById(Long.valueOf(req.getParameter("radioArtist"))), songService.findByTrackId(req.getParameter("radioSong")));
//        String TrackId = req.getParameter("radioSong");
//
//        resp.sendRedirect("/songDetails?TrackId=" + TrackId);
//    }
//}
