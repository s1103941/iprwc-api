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

/**
 *
 * @author abdoul
 */
// * 
// * @author Peter van Vliet
// */
public class Product {
    
    @NotEmpty
    @Length(min = 2, max = 100)
    @JsonView(View.Public.class)
    private String productName;

    @JsonView(View.Public.class)
    private Integer productId;
       
    @NotEmpty
    @Length(min = 1, max = 40)
    @JsonView(View.Public.class)
    private String productDescription;
   
    @JsonView(View.Public.class)
    private String productImage;
    
    @NotNull
    @JsonView(View.Public.class)
    private double productPrice;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    
    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

   
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
    
     
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

}
