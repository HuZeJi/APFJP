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
public class LlaveValorTo {
    @Id
    private Long id;
    private String val;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String value) {
        this.val = value;
    }

    @Override
    public String toString() {
        return "LlaveValorTo{" + "id=" + id + ", val=" + val + '}';
    }
    
    
}
