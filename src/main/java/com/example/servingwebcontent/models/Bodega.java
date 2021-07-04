/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vhjim
 */
@Entity
@Table(name = "bodega")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bodega.findAll", query = "SELECT b FROM Bodega b"),
    @NamedQuery(name = "Bodega.findById", query = "SELECT b FROM Bodega b WHERE b.id = :id"),
    @NamedQuery(name = "Bodega.findByDescipcion", query = "SELECT b FROM Bodega b WHERE b.descipcion = :descipcion"),
    @NamedQuery(name = "Bodega.findByDireccion", query = "SELECT b FROM Bodega b WHERE b.direccion = :direccion"),
    @NamedQuery(name = "Bodega.findByEstado", query = "SELECT b FROM Bodega b WHERE b.estado = :estado"),
    @NamedQuery(name = "Bodega.findByEmpleadoId", query = "SELECT b FROM Bodega b WHERE b.empleadoId = :empleadoId")})
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descipcion")
    private String descipcion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "estado")
    private Short estado;
    @Basic(optional = false)
    @Column(name = "empleado_id")
    private int empleadoId;

    public Bodega() {
    }

    public Bodega(Integer id) {
        this.id = id;
    }

    public Bodega(Integer id, int empleadoId) {
        this.id = id;
        this.empleadoId = empleadoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bodega)) {
            return false;
        }
        Bodega other = (Bodega) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bodega{" + "id=" + id + ", descipcion=" + descipcion + ", direccion=" + direccion + ", estado=" + estado + ", empleadoId=" + empleadoId + '}';
    }
    
    
    
}
