/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.controller;

import com.sergioarboleda.divinacomedia.app.model.HairProduct;
import com.sergioarboleda.divinacomedia.app.services.HairProductService;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *
 * @author Felipe_Sandoval
 */
@RestControllerAdvice
@RequestMapping("hairproducts")
@CrossOrigin(origins="*")
public class HairProductController {
    @Autowired
    private HairProductService service;
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody HairProduct hairproduct){ //se cambio a void, estaba en HairProduct
         service.save(hairproduct);
    }
    
//    @GetMapping("/all")
//    public List<HairProduct> getHairProduct(){
//        
//        return service.getAll();
//    }
    
    @GetMapping("/all")
    public List<HairProduct> getHairProduct(){
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<HairProduct> getOrder(@PathVariable("id") String id){
        return service.getOrder(id);
    }
    
    @GetMapping("/description/{description}")
    public List<HairProduct> getHairProductsByDescription(@PathVariable("description") String description){
        return service.getHairProductsByDescription(description);
    }
    
    @GetMapping("/price/{price}")
    public List<HairProduct> getHairProductsByPrice(@PathVariable("price") Double price){
        return service.getHairProductByPrice(price);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update (@RequestBody HairProduct hairproduct){ //se cambio a void, estaba en HairProduct
         service.update(hairproduct);
    }
    
    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference){
        return service.delete(reference);
    }
    
    
}
