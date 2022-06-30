package com.sena.demo.Model;

import java.sql.Date;
import java.util.List;

import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

//un album muchas canciones


   
@Entity
@Table(name="Album")
public class Album {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idAlbum;
       

        @Column( length=50)
        @NotEmpty
        private String nombreAlbum;
       

        @Column( nullable=true)
        private Boolean estadoAlbum;

        private Date anioPublicacion;
        //facturas

    @OneToMany(mappedBy = "albumes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Album> albumes;

    @ManyToOne(fetch = FetchType.LAZY)
    private Genero genero;

    @ManyToOne(fetch = FetchType.LAZY)
    private Artista artistas;



    public Album(){
        albumes =new ArrayList<Album>();
      
    }
    

    public Album(Integer idAlbum, String nombreAlbum, Boolean estadoAlbum,  Date anioPublicacion, List<Album> albumes, Genero genero,  Artista artistas) {
        this.idAlbum = idAlbum;
        this.nombreAlbum = nombreAlbum;
        this.estadoAlbum = estadoAlbum;
        this.anioPublicacion = anioPublicacion;
        this.albumes = albumes;
        this.genero = genero;
        this.artistas= artistas;

    }

    public List<Album> getAlbums() {
        return albumes;
    }

    public void setAlbums(List<Album> albumes) {
        this.albumes = albumes;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Integer getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Integer idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public Boolean getEstadoAlbum() {
        return estadoAlbum;
    }

    public void setEstadoAlbum(Boolean estadoAlbum) {
        this.estadoAlbum = estadoAlbum;
    }

    public Date getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Date anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }
    
}

    