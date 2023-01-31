/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;    
    private String nombreProy;
    private String descripcionProy;
    private String direccion;
    private String imagenP;
    

    public Proyecto() {
    }

    public Proyecto(String nombreProy, String descripcionProy, String direccion, String imagenP) {
        this.nombreProy = nombreProy;
        this.descripcionProy = descripcionProy;
        this.direccion = direccion;
        this.imagenP = imagenP;
        
    }    
}
