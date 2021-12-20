/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sergioarboleda.divinacomedia.app.model;

import java.util.Date;
import java.util.Map;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Geronimo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="orders")
public class Order {
    
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    
    private Map<String, HairProduct> products;
    private Map<String, Integer> quantities;
    
}
