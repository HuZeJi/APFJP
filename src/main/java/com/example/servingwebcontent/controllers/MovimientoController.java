/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Movimiento;
import com.example.servingwebcontent.models.to.LlaveValorTo;
import com.example.servingwebcontent.models.to.MovimientoTo;
import com.example.servingwebcontent.repository.LlaveValorToRepository;
import com.example.servingwebcontent.repository.MovimientoToRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vhjim
 */
@Controller
public class MovimientoController {
    
    @Autowired
    private MovimientoToRepository movimientoToRepository;
    
    @Autowired
    private LlaveValorToRepository llaveValorToRepository;
     
    @GetMapping("/movimientos")
    public String movimientos(Model model){
        List<LlaveValorTo> productosSelect = llaveValorToRepository.findAllProductosSelect();
        model.addAttribute("productosSelect", productosSelect);
        System.out.println("productos " + productosSelect); 
        List<LlaveValorTo> clientesSelect = llaveValorToRepository.findAllClientesSelect();
        model.addAttribute("clientesSelect", clientesSelect);
        System.out.println("clientes " + clientesSelect); 
        Movimiento movimiento = new Movimiento();
        model.addAttribute("movimiento", movimiento);
        return "movimiento.html";
    }
    @GetMapping("/movimientos/form")
    public String movimientosForm(Model model){
        List<MovimientoTo> movimientos = movimientoToRepository.findAllMovimientos();
        System.out.println(movimientos); 
        model.addAttribute("movimientos", movimientos);
        return "movimiento.view.html";
    }
}
