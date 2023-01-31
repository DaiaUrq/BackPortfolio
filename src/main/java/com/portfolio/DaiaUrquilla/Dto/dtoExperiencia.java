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
public class dtoExperiencia {
   @NotBlank
   private String nombreExp;
   @NotBlank
   private String descripcionExp;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreExp, String descripcionExp) {
        this.nombreExp = nombreExp;
        this.descripcionExp = descripcionExp;
    }  
   
}
