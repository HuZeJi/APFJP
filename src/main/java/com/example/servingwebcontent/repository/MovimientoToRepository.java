/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.to.MovimientoTo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Omen
 */
@Repository
public interface MovimientoToRepository extends CrudRepository<MovimientoTo, Integer> {
     @Query(
        value = "select m.id as id, m.observaciones as observacion, m.precio as precio, m.cantidad as cantidad, m.fecha as fecha, p.descripcion as producto,\n" +
"concat(per.nombres, concat(' ', per.apellidos)) as cliente, m.tipo as tipo, m.estado as estado\n" +
"from movimiento m, producto p, cliente c, persona per\n" +
"where p.id = m.producto_id and per.id = c.id", 
        nativeQuery = true)
    List<MovimientoTo> findAllMovimientos();
    
    @Query(
        value = "select m.id as id, m.observaciones as observacion, m.precio as precio, m.cantidad as cantidad, m.fecha as fecha, p.descripcion as producto,\n" +
"concat(per.nombres, concat(' ', per.apellidos)) as cliente, m.tipo as tipo, m.estado as estado\n" +
"from movimiento m, producto p, cliente c, persona per\n" +
"where p.id = m.producto_id and per.id = c.id and m.estado=1", 
        nativeQuery = true)
    List<MovimientoTo> findAllActivesMovimientos();
}
