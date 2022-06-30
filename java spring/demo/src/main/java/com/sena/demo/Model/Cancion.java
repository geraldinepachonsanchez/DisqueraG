package com.sena.demo.Model;

import javax.persistence.*;
import java.sql.Date;
import javax.validation.constraints.NotEmpty;



   
@Entity
@Table(name="Cancion")
public class Cancion {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idCancion;

        @Column( length=50)//validaciones
        @NotEmpty
        private String nombreCancion;
       
        @Column( nullable=true)
        private Boolean estadoCancion;
        
       
        private Date fechagrabacion;
        
        @Column(length=50)
        @NotEmpty
        private String duracionCancion;
        

        @ManyToOne(fetch = FetchType.LAZY)
        private Album albumes;
        
    
    


    public Cancion(){
        
    }

    
    public Cancion(Integer idCancion, String nombreCancion, Date fechagrabacion, String duracionCancion,
            Boolean estadoCancion, Album albumes) {
        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechagrabacion = fechagrabacion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
        this.albumes=albumes;
    }

    public Album getAlbumes() {
            return albumes;
        }


        public void setAlbumes(Album albumes) {
            this.albumes = albumes;
        }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracionCancion() {
        return duracionCancion;
    }

    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    public Date getFechagrabacion() {
        return fechagrabacion;
    }

    public void setFechagrabacion(Date fechagrabacion) {
        this.fechagrabacion = fechagrabacion;
    }

    public Boolean getEstadoCancion() {
        return estadoCancion;
    }

    public void setEstadoCancion(Boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }
    
}