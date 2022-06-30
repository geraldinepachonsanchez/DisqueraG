package com.sena.demo.service;

import java.util.List;

import com.sena.demo.Model.Cancion;
import com.sena.demo.Model.ICancion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancionServiceImpl implements ICancionService{
    @Autowired
    private ICancion canciond;

    

    @Override
    public List<Cancion> findAll() {
        
        return (List<Cancion>) canciond.findAll();
    }

    @Override
    public void save(Cancion cancion) {
        canciond.save(cancion);        
    }

    @Override
    public Cancion findOne(Integer idCancion) {
        
        return canciond.findById(idCancion).orElse(null);
    }

    @Override
    public void delete(Integer idCancion) {
        canciond.deleteById(idCancion);
        
    }
 
}