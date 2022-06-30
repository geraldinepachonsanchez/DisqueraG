package com.sena.demo.service;
import com.sena.demo.Model.Cancion;
import java.util.List;

public interface ICancionService {

    public List<Cancion> findAll(); //listar
    public void save (Cancion cancion); //agregar
    public Cancion findOne(Integer idCancion); //editar
    public void delete(Integer idCancion);
    
}
