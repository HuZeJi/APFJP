/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.to.BodegaTo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vhjim
 */
@Repository
public interface BodegaToRepository extends CrudRepository<BodegaTo, Integer>{
    @Query(
        value = "select b.id as id, b.descipcion as descipcion, b.direccion as direccion, concat(p.nombres, concat(' ', p.apellidos)) as encargado, b.estado as estado\n" +
                "from bodega b, empleado e, persona p\n" +
                "where b.empleado_id = e.id and e.persona_id = p.id", 
        nativeQuery = true)
    List<BodegaTo> findAllBodegas();
    
    @Query(
        value = "select b.id as id, b.descipcion as descipcion, b.direccion as direccion, concat(p.nombres, concat(' ', p.apellidos)) as encargado, b.estado as estado\n" +
                "from bodega b, empleado e, persona p\n" +
                "where b.empleado_id = e.id and e.persona_id = p.id and b.estado = 1", 
        nativeQuery = true)
    List<BodegaTo> findAllActivesBodegas();
}
