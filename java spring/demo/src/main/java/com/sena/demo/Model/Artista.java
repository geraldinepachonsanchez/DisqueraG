package com.sena.demo.Model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
  
@Entity
@Table(name="Artista")
public class Artista {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idArtista;
       
        @Column( length=50)
        private String noDocumento;

        @Column( length=50)
        private String tipoDocumento;
        
        @Column( length=50)
        private String nombreArtistsa;

        @Column( length=50)
        private String apellidoArtista;

        @Temporal(TemporalType.DATE)
        private Date feNacimArtsita;
        
        @Column( length=50)
        private String emailArtsita;

        @Column( nullable=true)
        private Boolean estadoArtista;

        @OneToMany(mappedBy = "albumes",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Album> albumes;

     
        @ManyToOne(fetch = FetchType.LAZY)
        private Disquera disquera;
    
        public Artista() {
            albumes=new ArrayList<Album>();
         
        }

        public Artista(Integer idArtista,  String noDocumento,  String tipoDocumento,
              String nombreArtistsa, String apellidoArtista, Date feNacimArtsita,
               String emailArtsita, Boolean estadoArtista , List<Album> albumes, Disquera disquera) {
            this.idArtista = idArtista;
            this.noDocumento = noDocumento;
            this.tipoDocumento = tipoDocumento;
            this.nombreArtistsa = nombreArtistsa;
            this.apellidoArtista = apellidoArtista;
            this.feNacimArtsita = feNacimArtsita;
            this.emailArtsita = emailArtsita;
            this.estadoArtista = estadoArtista;
            this.albumes = albumes;
            this.disquera = disquera;
        }
        public List<Album> getAlbums() {
            return albumes;
        }
    
        public void setAlbums(List<Album> albumes) {
            this.albumes = albumes;
        }

        
    public Disquera getDisqueras() {
        return disquera;
    }

    public void setDisqueras(Disquera disquera) {
        this.disquera = disquera;
    }

        public Integer getIdArtista() {
            return idArtista;
        }

        public void setIdArtista(Integer idArtista) {
            this.idArtista = idArtista;
        }

        public String getNoDocumento() {
            return noDocumento;
        }

        public void setNoDocumento(String noDocumento) {
            this.noDocumento = noDocumento;
        }

        public String getTipoDocumento() {
            return tipoDocumento;
        }

        public void setTipoDocumento(String tipoDocumento) {
            this.tipoDocumento = tipoDocumento;
        }

        public String getNombreArtistsa() {
            return nombreArtistsa;
        }

        public void setNombreArtistsa(String nombreArtistsa) {
            this.nombreArtistsa = nombreArtistsa;
        }

        public String getApellidoArtista() {
            return apellidoArtista;
        }

        public void setApellidoArtista(String apellidoArtista) {
            this.apellidoArtista = apellidoArtista;
        }

        public Date getFeNacimArtsita() {
            return feNacimArtsita;
        }

        public void setFeNacimArtsita(Date feNacimArtsita) {
            this.feNacimArtsita = feNacimArtsita;
        }

        public String getEmailArtsita() {
            return emailArtsita;
        }

        public void setEmailArtsita(String emailArtsita) {
            this.emailArtsita = emailArtsita;
        }

        public Boolean getEstadoArtista() {
            return estadoArtista;
        }

        public void setEstadoArtista(Boolean estadoArtista) {
            this.estadoArtista = estadoArtista;
        }

        
    }