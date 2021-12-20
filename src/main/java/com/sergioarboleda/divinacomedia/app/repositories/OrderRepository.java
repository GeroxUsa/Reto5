/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories;

import com.sergioarboleda.divinacomedia.app.model.Order;
import com.sergioarboleda.divinacomedia.app.repositories.crud.OrderCrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Felipe_Sandoval
 */
@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository repository;
    
    
    public List<Order> getAll(){
        return(List<Order>) repository.findAll();
    }
    
    public Optional<Order> getOrder(Integer id){
        return repository.findById(id);
    }
    
    public Order save(Order order){
        return repository.save(order);
    }
    
    public void delete(Order order){
        repository.delete(order);
    }
    
    public List<Order> getOrderByZone(String zone){
        return repository.getOrderByZone(zone);
    }
    
    public List<Order> getAllOrdersBySalesMan (Integer id){
        return repository.findBySalesManId(id);
    }
    
//    public List<Order> getOrdersByDateAndSalesManId(Date fecha, Integer id){
//        return repository.findByRegisterDayAndSalesMan_Id(fecha, id);
//    }
    
    public List<Order> getAllOrdersByRegisterDayAndSalesManId(Date registerDay,Date registerDay2, Integer id){
        return repository.findByRegisterDayBetweenAndSalesMan_Id(registerDay,registerDay2, id);
    }
    
    public List<Order> getOrdersByStatusAndSalesMan_Id(String status, Integer id){
        return repository.findByStatusAndSalesMan_Id(status,id);
    }
}
