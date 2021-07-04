/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.Bodega;
import com.example.servingwebcontent.models.to.BodegaTo;
import com.example.servingwebcontent.models.to.LlaveValorTo;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vhjim
 */
@Repository
public interface BodegaRepository extends CrudRepository<Bodega, Integer>{    
}
