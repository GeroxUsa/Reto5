/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.services;

import com.sergioarboleda.divinacomedia.app.model.Order;
import com.sergioarboleda.divinacomedia.app.repositories.OrderRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Geronimo
 */
@Service
public class OrderService {
    
    @Autowired
    private OrderRepository repository;
    
    /**
     * 
     * @return 
     */
    public List<Order> getAll(){
        return repository.getAll();
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Optional<Order> getOrder(Integer id) {
        return repository.getOrder(id);
    }
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order save (Order order){
        Optional<Order>existOrder = repository.getOrder(order.getId());
        if(existOrder.isEmpty()){
            return repository.save(order);
        }else{
            return order;
        }
    }
    
    /**
     * 
     * @param order
     * @return 
     */
    public Order update(Order order){
        if(order.getId() != null){
            Optional<Order> accesoryDb = repository.getOrder(order.getId());
            if(!accesoryDb.isEmpty()){
                if(order.getRegisterDay()!=null){
                    accesoryDb.get().setRegisterDay(order.getRegisterDay());
                }
                
                if(order.getStatus() != null){
                    accesoryDb.get().setStatus(order.getStatus());
                }
                
                if(order.getProducts() != null){
                    accesoryDb.get().setProducts(order.getProducts());
                }
                
                if(order.getSalesMan() != null){
                    accesoryDb.get().setSalesMan(order.getSalesMan());
                }
                
                if(order.getQuantities() != null){
                    accesoryDb.get().setQuantities(order.getQuantities());
                }
                
                repository.save(accesoryDb.get());
                return accesoryDb.get();
            }
            else{
                return order;
            }
        }else{
            return order;
        }
    }
    
    /**
     * 
     * @param reference
     * @return 
     */
    public boolean delete(Integer reference ){
        Boolean aBoolean = getOrder(reference).map(accesory -> {
            repository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    /**
     * 
     * @param zone
     * @return 
     */
    public List<Order> getOrderByZone(String zone){
        return repository.getOrderByZone(zone);
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public List<Order> getOrdersBySalesManId(Integer id){
        return repository.getAllOrdersBySalesMan(id);
    }
    
    
//    public List<Order> getOrdersByDateAndSalesManId(String fecha, Integer id) throws ParseException{
//        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
//        return repository.getOrdersByDateAndSalesManId(date, id);
//    }
    
    public List<Order> getOrdersByDateAndSalesManId(String registerDay, Integer id) throws ParseException{
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaActual = LocalDate.parse(registerDay,f);
        Date fecha1 = Date.from(fechaActual.plusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        Date fecha2 = Date.from(fechaActual.minusDays(1).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        
        return repository.getAllOrdersByRegisterDayAndSalesManId(fecha2,fecha1, id);
    }
    
    public List<Order> getOrdersByStatusAndSalesMan_Id(String status, Integer id){
        return repository.getOrdersByStatusAndSalesMan_Id(status,id);
    }
}
