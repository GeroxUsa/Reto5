/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories.crud;

import com.sergioarboleda.divinacomedia.app.model.HairProduct;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Felipe_Sandoval
 */
public interface HairProductCrudRepository extends MongoRepository<HairProduct,String>{
   
    @Query("{ 'description' : { $regex: ?0 } }")
    List<HairProduct> findHairProductByDescription ( String description);
    //@Query("{ 'price' : { $regex: ?0 } }")
    List<HairProduct> findHairProductByPrice(Double price);
}
