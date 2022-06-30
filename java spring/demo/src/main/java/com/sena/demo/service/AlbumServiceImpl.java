package com.sena.demo.service;

import java.util.List;

import com.sena.demo.Model.Album;
import com.sena.demo.Model.IAlbum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService{
    @Autowired
    private IAlbum albumd;

    @Override
    public List<Album> findAll() {
        
        return (List<Album>) albumd.findAll();
    }

    @Override
    public void save(Album album) {
       albumd.save(album);        
    }

    @Override
    public Album findOne(Integer idAlbum) {
        
        return albumd.findById(idAlbum).orElse(null);
    }

    @Override
    public void delete(Integer idAlbum) {
        albumd.deleteById(idAlbum);
        
    }
 
}