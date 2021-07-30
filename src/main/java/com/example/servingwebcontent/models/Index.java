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
 * @author adria
 */

@Entity

public class Index implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "precio")
    private Float precio;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "fecha")
    private Integer fecha;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private Integer productoId;
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private Integer clienteId;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "estado")
    private Short estado;

    public Index() {
    }
    
     public Index(Integer id) {
        this.id = id;
    }
     
    public Index(Integer id, int productoId) {
        this.id = id;
        this.productoId = productoId;
    } 
    
    public Integer getId() {
        return id;
    }
     
    public void setId(Integer id) {
        this.id = id;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    
    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setDireccion(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public Integer getFecha() {
        return fecha;
    }

    public void setFecha(Integer fecha) {
        this.fecha = fecha;
    }
    
    public Integer getProductoId() {
        return productoId;
    }

    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }
    
    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
        
    public Short getEstado() {
        return estado;
    }

    public void setEstado(Short estado) {
        this.estado = estado;
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
        if (!(object instanceof Index)) {
            return false;
        }
        Index other = (Index) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "Index{" + "id=" + id + ", observaciones=" + observaciones + ", precio=" + precio + ", cantidad=" + cantidad + ", fecha=" + fecha + ", productoId="+ productoId + ", clienteId" + clienteId + ", tipo=" + tipo + ", estado=" + estado + '}';
    }
    
}
