/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.servingwebcontent.controllers;

import com.example.servingwebcontent.models.Bodega;
import com.example.servingwebcontent.models.Descripcion;
import com.example.servingwebcontent.models.Producto;
import com.example.servingwebcontent.models.to.BodegaTo;
import com.example.servingwebcontent.models.to.LlaveValorTo;
import com.example.servingwebcontent.repository.BodegaRepository;
import com.example.servingwebcontent.repository.BodegaToRepository;
import com.example.servingwebcontent.repository.LlaveValorToRepository;
import com.example.servingwebcontent.repository.DescripcionRepository;
import com.example.servingwebcontent.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author vhjim
 */
@Controller
public class ProductoController {
    @Autowired
    private ProductoRepository productoRepository;
    @Autowired
    private DescripcionRepository descripcionRepository;
    @Autowired
    private BodegaToRepository bodegaToRepository;
    @Autowired
    private LlaveValorToRepository llaveValorToRepository;
    
    @GetMapping("/productos")
    public String productos(Model model){
        Iterable<Producto> productos = productoRepository.findByEstado(new Short("1"));
        model.addAttribute("productos", productos);
        return "producto.html";
    }
    
    @RequestMapping(
            value="/productos/delete/{idproducto}", 
            method= RequestMethod.GET
    )
    @ResponseBody
    public RedirectView removeProducto(
            @PathVariable("idproducto") Integer idproducto,
            Model model
    ) {
        Optional<Producto> productoToUpdate = productoRepository.findById(idproducto);
        Producto producto = productoToUpdate.get();
        producto.setEstado(Short.valueOf("0"));        
        productoRepository.save(producto);
        return new RedirectView("/productos");
    }
    
    /*---------------------------FORM*/
    
    @GetMapping("/productos/form")
    public String productosForm(Model model){        
        Producto producto = new Producto();
        
        model.addAttribute("producto", producto);
        
        return "producto.form.html";
    }
    
    @GetMapping("/productos/form/{idproducto}")
    public String productosForm(
            @PathVariable("idproducto") Integer idproducto,
            Model model
    ){        
        Optional<Producto> productoToUpdate = productoRepository.findById(idproducto);
        Producto producto = productoToUpdate.get();
        System.out.println("producto " + producto);
        
        List<Descripcion> descripciones = descripcionRepository.findByProductoId(idproducto);
        Descripcion descripcion = new Descripcion();
        
        model.addAttribute("descripcion", descripcion);
        
        model.addAttribute("descripciones", descripciones);
        
        model.addAttribute("producto", producto);
        return "producto.form.html";
    }   
    
    
    @RequestMapping(
            value="/productos/detalle/delete/{iddescripcion}/{idproducto}", 
            method= RequestMethod.GET
    )
    @ResponseBody
    public RedirectView removeDescripcion(
            @PathVariable("iddescripcion") Integer iddescripcion,
            @PathVariable("idproducto") Integer idproducto,
            Model model
    ) {
        Optional<Descripcion> descripcionToUpdate = descripcionRepository.findById(iddescripcion);
        Descripcion descripcion = descripcionToUpdate.get();
        descripcionRepository.delete(descripcion);
        return new RedirectView("/productos/form/" + idproducto);
    }
    
    
    @RequestMapping(
            value="/productos/detalle/create/{idproducto}", 
            method = RequestMethod.POST
    )
    @ResponseBody
    public RedirectView createDescripcion(
            @PathVariable("idproducto") Integer idproducto,
            @ModelAttribute(value="descripcion") Descripcion descripcion){
        System.out.println(descripcion);
        descripcion.setProductoId(idproducto);
        descripcionRepository.save(descripcion);
        return new RedirectView("/productos/form/" + idproducto);
    }
    
    @RequestMapping(
            value = "/productos/create",
            method = RequestMethod.POST
    )
    public RedirectView createProducto(@ModelAttribute(value="producto") Producto producto){
        System.out.println(producto);
        producto.setEstado(Short.valueOf("1"));
        productoRepository.save(producto);
        return new RedirectView("/productos");
    }
}
