/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vhjim
 */
@Controller
public class ClienteController {
    
    @GetMapping("/clientes")
    public String clientes(Model model){
        return "cliente.html";
    }
    @GetMapping("/clientes/form")
    public String clientesForm(Model model){
        return "cliente.form.html";
    }
}
