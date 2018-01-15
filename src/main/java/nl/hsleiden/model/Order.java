/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonView;
import javax.validation.constraints.NotNull;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Order {
    
    
    @Length(min = 1, max = 40)
    @JsonView(View.Public.class)
    private int orderID;
   
//    @NotNull
    @JsonView(View.Public.class)
    private int aantalProducten;
    
    @NotNull
    @JsonView(View.Public.class)
    private double totalePrijs;

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    
    public int getAantalProducten() {
        return aantalProducten;
    }

    public void setAantalProducten(int producten) {
        this.aantalProducten = producten;
    }
    
    public double getTotalePrijs() {
        return totalePrijs;
    }

    public void setTotalePrijs(double totalePrijs) {
        this.totalePrijs = totalePrijs;
    }
    
    
    
    
    
    
}
