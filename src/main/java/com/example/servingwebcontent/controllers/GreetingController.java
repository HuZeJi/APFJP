/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Persona;
import com.example.servingwebcontent.repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vhjim
 */
@Controller
public class GreetingController {
    
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/persona/todos")
    public String persona(Model model){
        Iterable<Persona> personas = personaRepository.findAll();
        System.out.println("personas " + personas);
        model.addAttribute("personas", personas);
        return "persona.html";
    }
}
