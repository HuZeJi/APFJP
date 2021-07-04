/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Personabu;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.servingwebcontent.repository.PersonabuRepository;

/**
 *
 * @author vhjim
 */
@Controller
public class GreetingController {
    
//    @Autowired
//    private PersonabuRepository personaRepository;

//    @GetMapping("/greeting")
//    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "greeting";
//    }
//    
//    @GetMapping("/persona/todos")
//    public String persona(Model model){
//        Iterable<Personabu> personas = personaRepository.findAll();
//        System.out.println("personas " + personas);
//        model.addAttribute("personas", personas);
//        return "persona.html";
//    }
}
