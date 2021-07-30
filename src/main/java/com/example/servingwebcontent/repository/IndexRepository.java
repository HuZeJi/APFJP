/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.models.Index;
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
public interface IndexRepository extends CrudRepository<Index, Integer>{
 
}
