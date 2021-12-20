/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.controller;

import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Felipe_Sandoval
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = "*")
public class UserController {
    /**
     * 
     */
    @Autowired
    private UserService service;
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return service.getAll();
    }
    /**
     * 
     * @param email
     * @return 
     */
    @GetMapping("emailexist/{user_email}")
    public boolean checkEmail(@PathVariable("user_email") String email){
        return service.checkUserByEmail(email);
    }
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    @GetMapping("/{user_email}/{user_password}")
    public User getUserByEmailAndPassword(@PathVariable("user_email") String email, @PathVariable("user_password") String password){
        return service.getUserByEmailAndPassword(email, password);
    }
    /**
     * 
     * @param user 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody User user){ //se cambio a void, estaba en User
        service.save(user);
    }
    /**
     * 
     * @param user 
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody User user){  //se cambio a void, estaba en user
        service.update(user);
    }
    /**
     * 
     * @param id
     * @return 
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    /**
     * 
     * @param id
     * @return 
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return service.getUserById(id);
    }
    /**
     * 
     * @param monthBirthtDay
     * @return 
     */
    @GetMapping("birthday/{monthBirthtDay}")
    public List<User> getUserByMonthBirthtDay (@PathVariable("monthBirthtDay") String monthBirthtDay){
        return service.getUserByMonthBirthtDay(monthBirthtDay);
    }
}
