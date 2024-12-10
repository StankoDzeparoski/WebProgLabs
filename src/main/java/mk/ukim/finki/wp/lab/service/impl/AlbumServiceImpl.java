package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Album;
//import mk.ukim.finki.wp.lab.repository.impl.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepositoryJpa;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepositoryJpa albumRepositoryJpa;

    public AlbumServiceImpl(AlbumRepositoryJpa albumRepositoryJpa) {
        this.albumRepositoryJpa = albumRepositoryJpa;
    }

    @Override
    public List<Album> findAll() {
        return this.albumRepositoryJpa.findAll();
    }

    @Override
    public Album findById(Long id) {
        return albumRepositoryJpa.findAlbumById(id);
    }


//    private final AlbumRepository albumRepository;
//
//    public AlbumServiceImpl(AlbumRepository albumRepository) {
//        this.albumRepository = albumRepository;
//    }
//
//    @Override
//    public List<Album> findAll() {
//        return this.albumRepository.findAll();
//    }
}
