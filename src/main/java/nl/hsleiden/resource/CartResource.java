
package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.Collection;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import nl.hsleiden.View;
import nl.hsleiden.model.Product;
import nl.hsleiden.service.CartService;


@Singleton
@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
public class CartResource {
    private final CartService service;
    
    @Inject
    public CartResource(CartService service) {
        this.service = service;
    }
    
    @GET
    @JsonView(View.Private.class)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Product> getAll(){
        return service.getAll();
    }
    
    @GET
    @Path("/totalPrice")
    @JsonView(View.Private.class)
    @Produces(MediaType.APPLICATION_JSON)
    public double getTotalPrice(){
      return service.getTotalPrice();
    }
    
    @POST
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@Valid Product product){
        System.out.println("Dit is de id : " + product.getProductId());
        service.delete(product.getProductId());
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id")int id){
        System.out.println(id);
        service.deleteCart(id);
    }
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addProduct(@Valid Product product){
        
        int cartID = 1;
        System.out.println("Dit is de zogenaamde id lol " + product.getProductId());
        service.insert(cartID, product.getProductId());
        
    }
    
}
