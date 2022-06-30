package com.sena.demo.service;

import java.util.List;

import com.sena.demo.Model.Genero;
import com.sena.demo.Model.IGenero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroServiceImpl implements IGeneroService{
    @Autowired
    private IGenero generod;

    

    @Override
    public List<Genero> findAll() {
        
        return (List<Genero>) generod.findAll();
    }

    @Override
    public void save(Genero genero) {
        generod.save(genero);        
    }

    @Override
    public Genero findOne(Integer Id) {
        
        return generod.findById(Id).orElse(null);
    }

    @Override
    public void delete(Integer Id) {
        generod.deleteById(Id);
        
    }
 
}