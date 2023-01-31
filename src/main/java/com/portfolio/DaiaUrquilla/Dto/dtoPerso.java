package com.portfolio.DaiaUrquilla.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


/**
 *
 * @author daiau
 */

@Getter
@Setter
public class dtoPerso {
    
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String acercaDe;
    @NotBlank
    private String titulo1;
    @NotBlank
    private String titulo2;
    @NotBlank
    private String img;

    public dtoPerso() {
    }

    public dtoPerso(String nombre, String apellido, String acercaDe, String titulo1, String titulo2, String img) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.acercaDe = acercaDe;
        this.titulo1 = titulo1;
        this.titulo2 = titulo2;
        this.img = img;
    }
}
