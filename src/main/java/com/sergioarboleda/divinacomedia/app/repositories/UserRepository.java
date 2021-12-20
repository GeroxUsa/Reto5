/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.repositories.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe_Sandoval
 */
@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository repository;
    
    /*
    *capa que conecta con los datos
    */
    public List<User> getAll(){
        return (List<User>) repository.findAll();
    }
    
    public Optional<User> getUserById(Integer id){
        return repository.findById(id);
    }
    
    public Optional<User> getUserByName(String name){
        return repository.getUserByName(name);
    }
    
    public Optional<User> getUserByEmail(String email){
        return repository.findUserByEmail(email);
    }
    
    public List<User> getUserByNameOrEmail (String name, String email){
        return repository.getUserByNameOrEmail(name, email);
    }
    
    public Optional<User> getUserByEmailAndPassword(String email, String password){
        return repository.findUserByEmailAndPassword(email, password);
    }
    
    public List<User> getUserByMonthBirthtDay (String monthBirthtDay){
        return repository.findUserByMonthBirthtDay(monthBirthtDay);
    }
    
    public User save(User user){
        return repository.save(user);
    }
    
    public void deleteUserById (int id){
        repository.deleteById(id);
    }
    
    public List<User> getUserByIdOrEmailOrName(Integer id, String email, String name){
        return repository.findByIdOrEmailOrName(id, email, name);
    }
    
    
    
}
