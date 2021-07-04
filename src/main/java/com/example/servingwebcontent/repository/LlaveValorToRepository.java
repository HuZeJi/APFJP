/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.to.BodegaTo;
import com.example.servingwebcontent.models.to.LlaveValorTo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vhjim
 */
@Repository
public interface LlaveValorToRepository extends CrudRepository<LlaveValorTo, Integer>{
    @Query(
        value = "select e.id as id, concat(concat(e.id, concat(' - ', concat(p.nombres, concat(' ', p.apellidos))))) as val \n" +
                "from empleado e, persona p \n" +
                "where e.persona_id = p.id", 
        nativeQuery = true)
    List<LlaveValorTo>findAllEmpleadosSelect();
}
