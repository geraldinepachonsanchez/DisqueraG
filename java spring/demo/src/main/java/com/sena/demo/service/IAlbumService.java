package com.sena.demo.service;
import java.util.List;

import com.sena.demo.Model.Album;



public interface IAlbumService {
   

//interfaz de acceso a dato



    public List<Album> findAll(); //listar
    public void save (Album album); //agregar
    public Album findOne(Integer idAlbum); //editar
    public void delete(Integer idAlbum);



}
