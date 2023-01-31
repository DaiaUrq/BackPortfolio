package com.portfolio.DaiaUrquilla.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author daiau
 */
@Getter
@Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreSkill;
    private int porcentaje;

    public Skill() {
    }

    public Skill(String nombre, int porcentaje) {
        this.nombreSkill = nombre;
        this.porcentaje = porcentaje;
    }
    
}
