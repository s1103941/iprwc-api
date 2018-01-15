/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;
import nl.hsleiden.model.Product;
import nl.hsleiden.service.OrderService;

@Singleton
@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    private final OrderService service;
    
    @Inject
    public OrderResource(OrderService service) {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Private.class)
    @RolesAllowed("ADMIN")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getOrders(){
        return service.getOrders();
    }
}