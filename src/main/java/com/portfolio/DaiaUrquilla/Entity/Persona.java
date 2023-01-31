package com.portfolio.DaiaUrquilla.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author Daia
 */
@Getter
@Setter
@Entity
public class Persona {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombre;
    
    @NotNull
    private String apellido;
    
    @NotNull
    private String acercaDe;
    
    @NotNull 
    private String titulo1;
    
    @NotNull 
    private String titulo2;
    
    private String img;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String acercaDe, String titulo1, String titulo2, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.img = img;
    }

  
    
    
}
