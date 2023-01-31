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
public class dtoSkill {
   @NotBlank
   private String nombreSkill;
   @NotBlank
   private int porcentaje;

    public dtoSkill() {
    }

    public dtoSkill(String nombreSkill, int porcentaje) {
        this.nombreSkill = nombreSkill;
        this.porcentaje = porcentaje;
    }  
}
