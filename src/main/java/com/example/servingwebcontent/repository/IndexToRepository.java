/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.to.IndexTo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author adria
 */
@Repository
public interface IndexToRepository extends CrudRepository<IndexTo, Integer>{
     @Query(
        value = "select pr.id as codigo, pr.descripcion as descripcion, sum(m.cantidad) as cantidad \n" +
"from producto pr, movimiento m \n" +
"where pr.id = m.producto_id\n" +
"group by codigo\n" +
"order by cantidad desc",
        nativeQuery = true)
    List<IndexTo> getIndex();

 

}
