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
public class dtoProyecto {

    @NotBlank
    private String nombreProy;
    @NotBlank
    private String descripcionProy;
    @NotBlank
    private String direccion;
   
    private String imagenP;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombreProy, String descripcionProy, String direccion, String imagenP) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.direccion = direccion;
        this.imagenP = imagenP;
        
    }

}
