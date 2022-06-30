package com.sena.demo.Controller;

import java.util.List;

import javax.validation.Valid;
import com.sena.demo.Model.Album;
import com.sena.demo.Model.Artista;
import com.sena.demo.Model.Genero;
import com.sena.demo.service.IAlbumService;
import com.sena.demo.service.IArtistaService;
import com.sena.demo.service.IGeneroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller

@SessionAttributes("album")
@RequestMapping("album")

public class AlbumController {
    
    //  Listar
    @Autowired
    private IAlbumService albumd;
    @Autowired
    private IGeneroService generod;
    @Autowired
    private IArtistaService artistad;

    @GetMapping("/listalbum")
        public String listalbum(Model m){
        m.addAttribute("album", albumd.findAll());
        return "view/listalbum";
}

//

    @GetMapping("/formalbum")     
    public String formgenero(Model m){
        Album album = new Album();
        List<Genero> genero= generod.findAll();
        List<Artista> artista= artistad.findAll();
        m.addAttribute("album", album);
        m.addAttribute("artistas", artista);
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar Album");
        return "view/addalbum"; 
    }

    @PostMapping("/add")
    public String add(@Valid Album album,Model m, BindingResult res,SessionStatus status){
    if(res.hasErrors()){
        return "view/addalbum";
        }
        albumd.save(album);
        status.setComplete();
        return "redirect:listalbum";
    
    }

    //Editar
    @GetMapping("/editaralbum/{idAlbum}")
        public String editar(@PathVariable Integer idAlbum,Model m){
            Album album = null;
            List<Genero> genero = generod.findAll();
            List<Artista> artista = artistad.findAll();
                if(idAlbum>0){
                album=albumd.findOne(idAlbum);
            }else{
                return "redirect:listalbum";
            }
                m.addAttribute("genero", genero);
                m.addAttribute("artistas", artista);
                m.addAttribute("album",album);
                m.addAttribute("accion", "Actualizar Album");
                return "view/addalbum";
        }

        @GetMapping("/eliminaralbum/{idAlbum}")
    public String delete(@PathVariable Integer idAlbum) {
        if(idAlbum >=1) {
            albumd.delete(idAlbum);
        }
        return "redirect:../listalbum";
    }
    
    
}

