/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.List;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Cart {
    
    private ArrayList<Product> products = new ArrayList<>();
    
    @Length(min = 2, max = 100)
    @JsonView(View.Public.class)
    private int cartID;
    
    private Product product;
    
    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(int id){
        products.remove(id);
    }

}
