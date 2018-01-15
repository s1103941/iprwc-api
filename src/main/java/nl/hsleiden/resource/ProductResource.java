/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import java.sql.SQLException;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;
import nl.hsleiden.model.Product;
import nl.hsleiden.service.ProductService;

/**
 *
 * @author abdoul
 */
@Singleton
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {
    private final ProductService service;
    
    @Inject
    public ProductResource(ProductService service) {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Private.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAll(){
        return service.getAll();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createClient(@Valid Product product) throws SQLException{
        service.insert(product);
        System.out.println(product.getProductName());
    }
    
}
