/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.models.to;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author vhjim
 */
@Entity
public class BodegaTo {
    @Id
    private Long id;
    private String descipcion;
    private String direccion;
    private String encargado;
    private Long estado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "BodegaTo{" + "id=" + id + ", descipcion=" + descipcion + ", direccion=" + direccion + ", encargado=" + encargado + ", estado=" + estado + '}';
    }
    
    
}
