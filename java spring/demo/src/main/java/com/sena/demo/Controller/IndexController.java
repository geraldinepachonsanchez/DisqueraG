package com.sena.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping

public class IndexController {
    @GetMapping(path={"/","","/index"}) 
    public String index(Model m){
        return "index";
    }

    @GetMapping("/genero")

    public String genero(){
        return "forward:/genero";
    }
 
    @GetMapping("/cancion")

    public String cancion(){
        return "forward:/cancion";
    }
    
}
