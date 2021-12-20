/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories.crud;

import com.sergioarboleda.divinacomedia.app.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Geronimo
 */
public interface UserCrudRepository extends MongoRepository<User, Integer>{
    
    
    public Optional<User> getUserByName(String name);
    
    //"Select * from user where user_name=' ' or user_email=''" *******equivalente de sql
    public List<User>getUserByNameOrEmail(String name, String email);
    
    
    public Optional<User> findUserByEmail(String email);
    
    
    public Optional<User> findUserByEmailAndPassword(String email, String password);
       
    //"db.usuarios.find({id:?,email:?,name:?});"
    public List<User> findByIdOrEmailOrName(Integer id, String email, String name);
    
    //exmpl
//    @Query("{id : ?0}") 
//    public Optional<User> getUserById;
    
    public List<User> findUserByMonthBirthtDay(String monthBirthtDay);
    
}
