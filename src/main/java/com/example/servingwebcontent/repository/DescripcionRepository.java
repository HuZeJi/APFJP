/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.Descripcion;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vhjim
 */
@Repository
public interface DescripcionRepository extends CrudRepository<Descripcion, Integer> {
    public List<Descripcion> findByProductoId(int productoId);
}
