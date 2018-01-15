/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.service;

import java.sql.SQLException;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.Product;
import nl.hsleiden.persistence.OrderDAO;
import nl.hsleiden.persistence.ProductDAO;

@Singleton
public class OrderService {
    
        
    private final OrderDAO dao;
    
    @Inject
    public OrderService(OrderDAO dao){
        this.dao=dao;
    }
     
    public Collection<Product> getOrders(){
        return dao.getAll();
    }
    
    
}
