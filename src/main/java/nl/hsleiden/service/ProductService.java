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
import nl.hsleiden.persistence.ProductDAO;

/**
 *
 * @author abdoul
 */
@Singleton
public class ProductService {
    
        
    private final ProductDAO dao;
    
    @Inject
    public ProductService(ProductDAO dao){
        this.dao=dao;
    }
    
    public void insert(Product product) throws SQLException{
        dao.add(product);
    }
    
    public Collection<Product> getAll(){
        return dao.getAll();
    }
    
    
}
