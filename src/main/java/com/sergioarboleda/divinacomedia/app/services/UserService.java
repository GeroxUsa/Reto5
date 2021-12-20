/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.services;

import com.sergioarboleda.divinacomedia.app.model.User;
import com.sergioarboleda.divinacomedia.app.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Felipe_Sandoval
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;
    //en esta se hacen validaciones
    //logica de negocio
    /**
     * 
     * @return 
     */
    public List<User> getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param user_mail
     * @return 
     */
    public boolean checkUserByEmail(String user_mail){

        return repository.getUserByEmail(user_mail).isPresent(); //Muuucho mas facil se puede usar en el siguiente metodo
    }
    
    /**
     * 
     * @param email
     * @param password
     * @return 
     */
    public User getUserByEmailAndPassword(String email, String password){

        Optional<User> user = repository.getUserByEmailAndPassword(email, password);
        System.out.println("-------------------------");
        System.out.println(email);
        System.out.println(password);
        System.out.println("-------------------------");
        if(user.isPresent()){
            return user.get();
        }else{
            return new User(null,null,null,null,null,null,null,null,null,null,null);
        }
    }
    /**
     * 
     * @param monthBirthtDay
     * @return 
     */
    public List<User> getUserByMonthBirthtDay (String monthBirthtDay){
        return repository.getUserByMonthBirthtDay(monthBirthtDay);
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User save(User user){
        if(user.getId()==null){
            return user;
        }else{
            
            if(user.getIdentification()==null || user.getEmail()==null || user.getName()==null 
                    || user.getPassword()== null || user.getType()==null){
                return user;
            }else{
                List<User> existUsers = repository.getUserByIdOrEmailOrName(user.getId(), user.getEmail(), user.getName());
                if(existUsers.isEmpty()){
                    return repository.save(user);
                }else{
                    return user;
                }

            }
        }
        
    }
    
    /**
     * 
     * @param user
     * @return 
     */
    public User update(User user){
        Optional<User> existUser = repository.getUserById(user.getId());
        if(existUser.isPresent()){
            if(user.getIdentification()!=null){
                existUser.get().setIdentification(user.getIdentification());
            }
            if(user.getName()!=null){
                existUser.get().setName(user.getName());
            }
            if(user.getAddress()!=null){
                existUser.get().setAddress(user.getAddress());
            }
            if(user.getCellPhone()!=null){
                existUser.get().setCellPhone(user.getCellPhone());
            }
            if(user.getEmail()!=null){
                existUser.get().setEmail(user.getEmail());
            }
            if(user.getPassword()!=null){
                existUser.get().setPassword(user.getPassword());
            }
            if(user.getZone()!=null){
                existUser.get().setZone(user.getZone());
            }
            if(user.getType()!=null){
                existUser.get().setType(user.getType());
            }
            return repository.save(existUser.get());
        }
        else{
            return null;
        }
    }
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(int id){
        Boolean aBoolean = repository.getUserById(id).map(user -> {
            repository.deleteUserById(user.getId());
            return true;
        }).orElse(false);
        return aBoolean;
        //return repository.deleteUserById(id);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public User getUserById(Integer id){
        return repository.getUserById(id).orElse(new User());
    }
}
