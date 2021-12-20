/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.model.HairProduct;
import com.sergioarboleda.divinacomedia.app.repositories.crud.HairProductCrudRepository;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe_Sandoval
 */
@Repository
public class HairProductRepository {
    
    @Autowired
    private HairProductCrudRepository repository;
    
    public List<HairProduct> getAll(){
        return(List<HairProduct>) repository.findAll();
    }
    
    public Optional<HairProduct> getHairProductById(String id){
        return repository.findById(id);
    }
    
    public List<HairProduct> getHairProductsByDescription ( String description){
        return repository.findHairProductByDescription(description);
    }
    
    public List<HairProduct> getHairProductByPrice(Double price){
        return repository.findHairProductByPrice(price);
    }
    
    public HairProduct save(HairProduct hairproduct){
        return repository.save(hairproduct);
    }
    
//    public void deleteHairProductByReference(String reference){
//        repository.deleteById(reference);
//    }
    
    public void deleteHairProductById(String id){
        repository.deleteById(id);
    }
    
}
