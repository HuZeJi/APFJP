/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Bodega;
import com.example.servingwebcontent.models.to.BodegaTo;
import com.example.servingwebcontent.models.to.LlaveValorTo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;
import com.example.servingwebcontent.repository.BodegaToRepository;
import com.example.servingwebcontent.repository.BodegaRepository;
import com.example.servingwebcontent.repository.LlaveValorToRepository;
import java.util.Optional;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author vhjim
 */
@Controller
public class BodegaController {
    @Autowired
    private BodegaRepository bodegaRepository;
    @Autowired
    private BodegaToRepository bodegaToRepository;
    @Autowired
    private LlaveValorToRepository llaveValorToRepository;
    
    @GetMapping("/bodegas")
    public String bodegas(Model model){
        List<BodegaTo> bodegas = bodegaToRepository.findAllBodegas();
        System.out.println("bodegas " + bodegas);
        model.addAttribute("bodegas", bodegas);
        return "bodega.html";
    }
    @RequestMapping(
            value="/bodegas/delete/{idbodega}", 
            method= RequestMethod.GET
    )
    @ResponseBody
    public RedirectView  emoveBodega(
            @PathVariable("idbodega") Integer idbodega,
            Model model
    ) {
        System.out.println(idbodega);
        Optional<Bodega> bodegaToUpdate = bodegaRepository.findById(idbodega);
        Bodega bodega = bodegaToUpdate.get();
        bodega.setEstado(Short.valueOf("0"));        
        bodegaRepository.save(bodega);
        return new RedirectView("/bodegas");
    }
    
    /*---------------------------FORM*/
    
    @GetMapping("/bodegas/form")
    public String bodegasForm(Model model){
        List<LlaveValorTo> empleadosSelect = llaveValorToRepository.findAllEmpleadosSelect();
        System.out.println("empleados " + empleadosSelect);
        
        Bodega bodega = new Bodega();
        
        model.addAttribute("bodega", bodega);
        
        model.addAttribute("empleadosSelect", empleadosSelect);
        return "bodega.form.html";
    }
    
    @GetMapping("/bodegas/form/{idbodega}")
    public String bodegasForm(
            @PathVariable("idbodega") Integer idbodega,
            Model model
    ){
        List<LlaveValorTo> empleadosSelect = llaveValorToRepository.findAllEmpleadosSelect();
        System.out.println("empleados " + empleadosSelect);
        
        Optional<Bodega> bodegaToUpdate = bodegaRepository.findById(idbodega);
        Bodega bodega = bodegaToUpdate.get();
        System.out.println("bodega " + bodega);
        
        model.addAttribute("bodega", bodega);
        
        model.addAttribute("empleadosSelect", empleadosSelect);
        return "bodega.form.html";
    }        
    
    @RequestMapping(
            value = "/bodegas/create",
            method = RequestMethod.POST
    )
    public RedirectView createBodega(@ModelAttribute(value="bodega") Bodega bodega){
        System.out.println(bodega);
        bodega.setEstado(Short.valueOf("1"));
        bodegaRepository.save(bodega);
        return new RedirectView("/bodegas");
    }
}
