package com.sena.demo.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table (name="genero")
public class Genero {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer Id;
        

        @Column( length=50)
        @NotEmpty 
        private String Nombre;
        
//cliente
        @Column( nullable=true)
        private Boolean Estado;

        @OneToMany(mappedBy = "genero",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Album> albumes;
      
        
        
        

        public Genero(){
            albumes=new ArrayList<Album>();
        
    
    }

    public Genero(Integer Id, String Nombre, Boolean Estado){
        this.Id = Id;
        this.Nombre = Nombre;
        this.Estado = Estado;
    }
    
    public List<Album> getAlbumes() {
        return albumes;
    }

    public void setAlbumes(List<Album> albumes) {
        this.albumes = albumes;
    }
    
    public void setId(Integer Id) {
        this.Id = Id;
    }
    public Integer getId() {
        return Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void setEstado(Boolean estado) {
        Estado = estado;
    }
    
    public Boolean getEstado() {
        return Estado;
    }

    public List<Genero> findAll() {
        return null;
    }

    

    
    
}
    
    


