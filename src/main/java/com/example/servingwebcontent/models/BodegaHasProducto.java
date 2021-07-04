/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vhjim
 */
@Entity
@Table(name = "bodega_has_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BodegaHasProducto.findAll", query = "SELECT b FROM BodegaHasProducto b"),
    @NamedQuery(name = "BodegaHasProducto.findByBodegaId", query = "SELECT b FROM BodegaHasProducto b WHERE b.bodegaHasProductoPK.bodegaId = :bodegaId"),
    @NamedQuery(name = "BodegaHasProducto.findByProductoId", query = "SELECT b FROM BodegaHasProducto b WHERE b.bodegaHasProductoPK.productoId = :productoId"),
    @NamedQuery(name = "BodegaHasProducto.findByCantidad", query = "SELECT b FROM BodegaHasProducto b WHERE b.cantidad = :cantidad")})
public class BodegaHasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BodegaHasProductoPK bodegaHasProductoPK;
    @Column(name = "cantidad")
    private Integer cantidad;

    public BodegaHasProducto() {
    }

    public BodegaHasProducto(BodegaHasProductoPK bodegaHasProductoPK) {
        this.bodegaHasProductoPK = bodegaHasProductoPK;
    }

    public BodegaHasProducto(int bodegaId, int productoId) {
        this.bodegaHasProductoPK = new BodegaHasProductoPK(bodegaId, productoId);
    }

    public BodegaHasProductoPK getBodegaHasProductoPK() {
        return bodegaHasProductoPK;
    }

    public void setBodegaHasProductoPK(BodegaHasProductoPK bodegaHasProductoPK) {
        this.bodegaHasProductoPK = bodegaHasProductoPK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bodegaHasProductoPK != null ? bodegaHasProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegaHasProducto)) {
            return false;
        }
        BodegaHasProducto other = (BodegaHasProducto) object;
        if ((this.bodegaHasProductoPK == null && other.bodegaHasProductoPK != null) || (this.bodegaHasProductoPK != null && !this.bodegaHasProductoPK.equals(other.bodegaHasProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.servingwebcontent.models.BodegaHasProducto[ bodegaHasProductoPK=" + bodegaHasProductoPK + " ]";
    }
    
}
