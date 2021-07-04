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
@Table(name = "detalles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalles.findAll", query = "SELECT d FROM Detalles d"),
    @NamedQuery(name = "Detalles.findById", query = "SELECT d FROM Detalles d WHERE d.id = :id"),
    @NamedQuery(name = "Detalles.findByLlave", query = "SELECT d FROM Detalles d WHERE d.llave = :llave"),
    @NamedQuery(name = "Detalles.findByValor", query = "SELECT d FROM Detalles d WHERE d.valor = :valor"),
    @NamedQuery(name = "Detalles.findByPersonaId", query = "SELECT d FROM Detalles d WHERE d.personaId = :personaId")})
public class Detalles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "llave")
    private String llave;
    @Column(name = "valor")
    private String valor;
    @Basic(optional = false)
    @Column(name = "persona_id")
    private int personaId;

    public Detalles() {
    }

    public Detalles(Integer id) {
        this.id = id;
    }

    public Detalles(Integer id, int personaId) {
        this.id = id;
        this.personaId = personaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLlave() {
        return llave;
    }

    public void setLlave(String llave) {
        this.llave = llave;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getPersonaId() {
        return personaId;
    }

    public void setPersonaId(int personaId) {
        this.personaId = personaId;
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
        if (!(object instanceof Detalles)) {
            return false;
        }
        Detalles other = (Detalles) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.servingwebcontent.models.Detalles[ id=" + id + " ]";
    }
    
}
