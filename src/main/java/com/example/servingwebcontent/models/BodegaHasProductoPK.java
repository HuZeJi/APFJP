/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author vhjim
 */
@Embeddable
public class BodegaHasProductoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "bodega_id")
    private int bodegaId;
    @Basic(optional = false)
    @Column(name = "producto_id")
    private int productoId;

    public BodegaHasProductoPK() {
    }

    public BodegaHasProductoPK(int bodegaId, int productoId) {
        this.bodegaId = bodegaId;
        this.productoId = productoId;
    }

    public int getBodegaId() {
        return bodegaId;
    }

    public void setBodegaId(int bodegaId) {
        this.bodegaId = bodegaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) bodegaId;
        hash += (int) productoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BodegaHasProductoPK)) {
            return false;
        }
        BodegaHasProductoPK other = (BodegaHasProductoPK) object;
        if (this.bodegaId != other.bodegaId) {
            return false;
        }
        if (this.productoId != other.productoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.servingwebcontent.models.BodegaHasProductoPK[ bodegaId=" + bodegaId + ", productoId=" + productoId + " ]";
    }
    
}
