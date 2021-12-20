/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.controller;

import com.sergioarboleda.divinacomedia.app.model.Order;
import com.sergioarboleda.divinacomedia.app.services.OrderService;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("order")
@CrossOrigin(origins="*")
public class OrderController {
    @Autowired
    private OrderService orderservice;
    
    @GetMapping("/all")
    public List<Order> getAll(){
        return orderservice.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id){
        return orderservice.getOrder(id);
    }
    
    @GetMapping("/zona/{zone}")
    public List<Order> getOrderByZone(@PathVariable("zone") String zone){
        return orderservice.getOrderByZone(zone);
    }
    
    @GetMapping("/salesman/{id}")
    public List<Order> getOrdersBySalesManId(@PathVariable("id") Integer id){
        return orderservice.getOrdersBySalesManId(id);
    }
    
    @GetMapping("/date/{fecha}/{id}")
    public List<Order> getOrdersByDateAndSalesManId(@PathVariable("fecha") String fecha, @PathVariable("id") Integer id) throws ParseException{
        System.out.println(fecha);
        return orderservice.getOrdersByDateAndSalesManId(fecha,id);
    }
    
    @GetMapping("/state/{state}/{id}")
    public List<Order> getOrdersByStatusAndSalesMan_Id(@PathVariable("state") String status,@PathVariable("id") Integer id){
        return orderservice.getOrdersByStatusAndSalesMan_Id(status,id);
    } 
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderservice.save(order);
    } 
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody Order order){
        orderservice.update(order);
    }
    
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Integer id){
        return orderservice.delete(id);
    }
    
    
}
