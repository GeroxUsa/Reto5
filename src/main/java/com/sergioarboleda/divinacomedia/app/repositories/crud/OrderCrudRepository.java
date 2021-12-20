/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.repositories.crud;

import com.sergioarboleda.divinacomedia.app.model.Order;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Geronimo
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer>{
    
    @Query("{\"salesMan.zone\":?0}")
    public List<Order> getOrderByZone(String zone);
    
    @Query("{'salesMan.id':?0}")
    List<Order> findBySalesManId (Integer id);
    
    List<Order> findByRegisterDayAndSalesMan_Id(Date fecha, Integer id);
    
    List<Order>findByRegisterDayBetweenAndSalesMan_Id(Date registerDay, Date registerDay2, Integer id);
    
    List<Order> findByStatusAndSalesMan_Id(String status, Integer id);
}
