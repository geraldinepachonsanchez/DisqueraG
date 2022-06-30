package com.sena.demo.Model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
    
   
@Entity
@Table(name="Disquera")
public class Disquera {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idDisquera;
       

        @Column( length=50)
        @NotEmpty
        private String nitDisquera;

        @Column( length=50)
        @NotEmpty
        private String nombreDisquera;
        
        @Column( length=50)
        @NotEmpty
        private String telefonoDisquera;

        @Column( length=50)
        @NotEmpty
        private String direccionDisquera;

        @Column( nullable=true)
        private Boolean estadoDisquera;

        @OneToMany(mappedBy = "disquera",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Artista> artista;
      
        
       

        public Disquera() {
            artista=new ArrayList<Artista>();
        }

        public Disquera(Integer idDisquera, @NotEmpty String nitDisquera, @NotEmpty String nombreDisquera,
                @NotEmpty String telefonoDisquera, @NotEmpty String direccionDisquera, Boolean estadoDisquera) {
            this.idDisquera = idDisquera;
            this.nitDisquera = nitDisquera;
            this.nombreDisquera = nombreDisquera;
            this.telefonoDisquera = telefonoDisquera;
            this.direccionDisquera = direccionDisquera;
            this.estadoDisquera = estadoDisquera;
        }

        public List<Artista> getArtistas() {
            return artista;
        }

        public void setArtistas(List<Artista> artista) {
            this.artista = artista;
        }

        public Integer getIdDisquera() {
            return idDisquera;
        }

        public void setIdDisquera(Integer idDisquera) {
            this.idDisquera = idDisquera;
        }

        public String getNitDisquera() {
            return nitDisquera;
        }

        public void setNitDisquera(String nitDisquera) {
            this.nitDisquera = nitDisquera;
        }

        public String getNombreDisquera() {
            return nombreDisquera;
        }

        public void setNombreDisquera(String nombreDisquera) {
            this.nombreDisquera = nombreDisquera;
        }

        public String getTelefonoDisquera() {
            return telefonoDisquera;
        }

        public void setTelefonoDisquera(String telefonoDisquera) {
            this.telefonoDisquera = telefonoDisquera;
        }

        public String getDireccionDisquera() {
            return direccionDisquera;
        }

        public void setDireccionDisquera(String direccionDisquera) {
            this.direccionDisquera = direccionDisquera;
        }

        public Boolean getEstadoDisquera() {
            return estadoDisquera;
        }

        public void setEstadoDisquera(Boolean estadoDisquera) {
            this.estadoDisquera = estadoDisquera;
        }

       
}
