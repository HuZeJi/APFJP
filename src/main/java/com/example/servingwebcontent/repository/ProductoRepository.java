/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.Producto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author vhjim
 */
public interface ProductoRepository extends CrudRepository<Producto, Integer>{
    
    List<Producto> findByIdAndEstado(Integer id, Short estado);
    List<Producto> findByEstado(Short estado);
    
}
