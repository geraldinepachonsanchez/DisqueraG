package com.sena.demo.Controller;


import javax.validation.Valid;

import com.sena.demo.Model.Genero;
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


//CAPA DE PRESENTACION
@Controller
@SessionAttributes("genero")
@RequestMapping("/genero")


public class GeneroController {

    //  Listar
    @Autowired
    private IGeneroService generod;
    
    @GetMapping("/listgenero")
        public String listgenero(Model m){
        m.addAttribute("genero", generod.findAll());
        return "view/listgenero";
}

@GetMapping("/ver-genero/{Id}")
public String veralbumgenero(@PathVariable Integer Id,Model m){
Genero genero=null;
if(Id>0){
genero=generod.findOne(Id);
}else{
return "redirect:listgenero";
}
m.addAttribute("genero",genero);
m.addAttribute("accion", "Albumes de ese genero");
return "view/generoalbum";
}
    //  Agregar
    @GetMapping("/form")     
    public String formgenero(Model m){
        Genero genero = new Genero();
        m.addAttribute("genero", genero);
        m.addAttribute("accion", "Agregar genero");
        return "view/addgenero"; 
    }

    @PostMapping("/add")
    public String add(@Valid Genero genero,Model m, BindingResult res,SessionStatus status){
    if(res.hasErrors()){
        return "view/addgenero";
        }
        generod.save(genero);
        status.setComplete();
        return "redirect:listgenero";
    
    }

    //Editar
    @GetMapping("/editar/{Id}")
        public String editar(@PathVariable Integer Id,Model m){
            Genero genero = null;
                if(Id>0){
                genero=generod.findOne(Id);
            }else{
                return "redirect:listgenero";
            }
                m.addAttribute("genero",genero);
                m.addAttribute("accion", "Actualizar Genero");
                return "view/addgenero";
        }

        @GetMapping("/eliminar/{Id}")
    public String delete(@PathVariable Integer Id) {
        if(Id >=1) {
            generod.delete(Id);
        }
        return "redirect:../listgenero";
    }
    
    
     

    
}
    

