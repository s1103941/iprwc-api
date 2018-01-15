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
import nl.hsleiden.persistence.CartDAO;

@Singleton
public class CartService {
    
        
    private final CartDAO dao;
    
    @Inject
    public CartService(CartDAO dao){
        this.dao=dao;
    }
    
    public void insert(int cartID, int productID) {
            dao.add(cartID, productID);
    }
    
    public Collection<Product> getAll(){
        return dao.getAll();
    }
    
    
    public void delete(int id) {
        dao.delete(id);
    }
    
    public double getTotalPrice(){
        return dao.getTotalPrice();
    }
    
    public void deleteCart(int id){
        dao.deleteCart(id);
    }
    
}
