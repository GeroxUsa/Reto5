/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.services;

import com.sergioarboleda.divinacomedia.app.model.HairProduct;
import com.sergioarboleda.divinacomedia.app.repositories.HairProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe_Sandoval
 */
@Service
public class HairProductService {
    @Autowired
    private HairProductRepository repository;
    

    
    public List<HairProduct> getAll(){
        return repository.getAll();
        //List<HairProduct> lista_in = repository.getAll();
//        HairProduct temp = new HairProduct();
//        
//        List<HairProduct> lista_out = new ArrayList<HairProduct>();
//        
//        for(HairProduct hair: lista_in){
//            temp.setReference(hair.getReference());
//            temp.setBrand(hair.getBrand());
//            temp.setCategory(hair.getCategory());
//            temp.setName(hair.getName());
//            temp.setDescription(hair.getDescription());
//            temp.setAvailability(hair.isAvailability());
//            temp.setPrice(hair.getPrice());
//            temp.setQuantity(hair.getQuantity());
//            temp.setPhotography(hair.getPhotography());
//            
//            lista_out.add(temp);
//        }
//        return (List<HairProduct>)lista_out;
    }
    
    public HairProduct save(HairProduct hairproduct){
        Optional<HairProduct>existHairProduct = repository.getHairProductById(hairproduct.getId());
        if(existHairProduct.isEmpty()){
//            int max_id=0;
//            List<HairProduct> listaHair= repository.getAll();
//            for( HairProduct hair: listaHair){
//                if(hair.getId()>max_id)
//                    max_id=hair.getId();
//            }
//            System.out.println(max_id);
//            hairproduct.setId(max_id+1);
            return repository.save(hairproduct);
        }else{
            return hairproduct;
        }
    }
    
    public HairProduct update(HairProduct hairproduct){
        Optional<HairProduct> existHairProduct = repository.getHairProductById(hairproduct.getId());
        System.out.println("-------------------------------");
        System.out.println(existHairProduct);
        System.out.println("-------------------------------");
        if(existHairProduct.isPresent()){
            if(hairproduct.getBrand()!=null){
                existHairProduct.get().setBrand(hairproduct.getBrand());
            }
            if(hairproduct.getCategory()!=null){
                existHairProduct.get().setCategory(hairproduct.getCategory());
            }
            if(hairproduct.getName()!=null){
                existHairProduct.get().setName(hairproduct.getName());
            }
            if(hairproduct.getDescription()!=null){
                existHairProduct.get().setDescription(hairproduct.getDescription());
            }
            if(hairproduct.isAvailability()!=true){
                existHairProduct.get().setAvailability(hairproduct.isAvailability());
            }
            if(hairproduct.getPrice()!=0){
                existHairProduct.get().setPrice(hairproduct.getPrice());
            }
            if(hairproduct.getQuantity()!=0){
                existHairProduct.get().setQuantity(hairproduct.getQuantity());
            }
            if(hairproduct.getPhotography()!=null){
                existHairProduct.get().setPhotography(hairproduct.getPhotography());
            }
            return repository.save(existHairProduct.get());
        }
        else{
            return null;
        }
    }
    
    public boolean delete(String reference){ //recibir el objeto directamente, cambiar en servicio para enviar el obj
        Boolean aBoolean = repository.getHairProductById(reference).map(hairproduct-> {
            repository.deleteHairProductById(hairproduct.getId());
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public Optional<HairProduct> getOrder(String id) {
        return repository.getHairProductById(id);
    }
    
    public List<HairProduct> getHairProductsByDescription ( String description){
        List<HairProduct> ProductoEntrada= repository.getHairProductsByDescription(description);
        if(ProductoEntrada.isEmpty()){
            System.out.println(ProductoEntrada);
            ProductoEntrada =repository.getHairProductsByDescription(description.toUpperCase());   
        }
        return ProductoEntrada;
    }
    
    public List<HairProduct> getHairProductByPrice(Double price){
        return repository.getHairProductByPrice(price);
    }
}
