package com.sena.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.demo.Model.Artista;
import com.sena.demo.Model.IArtista;




@Service

public class ArtistaServiceImpl implements IArtistaService{
@Autowired
private IArtista artistad;

@Override
public List<Artista> findAll() {
return (List<Artista>) artistad.findAll();
}

}