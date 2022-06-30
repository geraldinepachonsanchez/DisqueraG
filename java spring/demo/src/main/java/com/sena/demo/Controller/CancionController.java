package com.sena.demo.Controller;

import java.util.List;

import javax.validation.Valid;
import com.sena.demo.Model.Cancion;
import com.sena.demo.service.ICancionService;

import com.sena.demo.Model.Album;
import com.sena.demo.service.IAlbumService;

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

@SessionAttributes("cancion")
@RequestMapping("cancion")

public class CancionController {
    
    //  Listar
    @Autowired
    private ICancionService canciond;

    @Autowired
    private IAlbumService albumd;

    @GetMapping("/listcancion")
        public String listcancion(Model m){
        m.addAttribute("cancion", canciond.findAll());
        return "view/listcancion";
}


    @GetMapping("/formcancion")     
    public String formgenero(Model m){
        Cancion cancion = new Cancion();
        List<Album> albumes=albumd.findAll();
        m.addAttribute("cancion", cancion);
        m.addAttribute("albumes", albumes);
        m.addAttribute("accion", "Agregar Cancion");
        return "view/addcancion"; 
    }

    @PostMapping("/addcancion")
    public String add(@Valid Cancion cancion,Model m, BindingResult res,SessionStatus status){
    if(res.hasErrors()){
        return "view/addcancion";
        }
        canciond.save(cancion);
        status.setComplete();
        return "redirect:listcancion";
    
    }

    //Editar
    @GetMapping("/editarcancion/{idCancion}")
        public String editar(@PathVariable Integer idCancion,Model m){
            Cancion cancion = null;
            List<Album> albumes = albumd.findAll();
                if(idCancion>0){
                cancion=canciond.findOne(idCancion);
            }else{
                return "redirect:listcancion";
            }
            m.addAttribute("albumes", albumes);
                m.addAttribute("cancion",cancion);
                m.addAttribute("accion", "Actualizar Cancion");
                return "view/addcancion";
        }

        @GetMapping("/eliminarcancion/{idCancion}")
    public String delete(@PathVariable Integer idCancion) {
        if(idCancion >=1) {
            canciond.delete(idCancion);
        }
        return "redirect:../listcancion";
    }
    
    
}
