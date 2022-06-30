package com.sena.demo.service;
import java.util.List;

import com.sena.demo.Model.Genero;



public interface IGeneroService {
   

//interfaz de acceso a dato



    public List<Genero> findAll(); //listar
    public void save (Genero genero); //agregar
    public Genero findOne(Integer Id); //editar
    public void delete(Integer Id);



}
