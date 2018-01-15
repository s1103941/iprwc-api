/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hsleiden.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nl.hsleiden.model.Cart;
import nl.hsleiden.model.Product;

/**
 *
 * @author abdoul
 */

public class CartDAO {
    
    private final Database db;
    private Cart cart;
    private OrderDAO orderdao;
    
    public CartDAO(){
        db = new Database();
        orderdao = new OrderDAO();
        
    }
    
    public void add(int cartID, int productID) {
     Connection con = db.getConnection();
     PreparedStatement ps;
        try {
            ps = con.prepareStatement("insert into cart(cartID, productID) values(?,?);");
            ps.setInt(1, 1);
            ps.setInt(2, productID);
            ps.execute();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   
          
    }
    
    public void delete(int id) {
        
        Connection con = db.getConnection();
        try {
            
            PreparedStatement ps = con.prepareStatement("delete from Cart where cartID = ? and productID = ?;");
            ps.setInt(1, 1);
            ps.setInt(2, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        db.closeConnection(con);
    }
    
    public void deleteCart(int id) {
        
        System.out.println("Hier kom ik eerst");
        
        ArrayList<Product> producten = new ArrayList<>();
        producten = getAll();
        
        orderdao.addOrder(producten);
        
        Connection con = db.getConnection();
        PreparedStatement ps;
        try {
            ps = con.prepareStatement("delete from Cart;");
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Hier kom derde");
        db.closeConnection(con);
    }
    
    public double getTotalPrice(){
        
        double aantal = 0;
        double totaal = 0;
        
         try{
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product,cart where cart.cartID = 1 and cart.productID = product.productID");
            while(rs.next()){
               
               aantal = rs.getDouble("productPrice");
               totaal += aantal;
            }
            db.closeConnection(con);
            
        }   catch(SQLException e){
            e.printStackTrace();
    }
       
        
        return totaal;
    }
    
    public ArrayList getAll(){
        
        Cart cart = new Cart();
        
        try{
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from product,cart where cart.cartID = 1 and cart.productID = product.productID");
            Product product;
            while(rs.next()){
               product = new Product();
               product.setProductName(rs.getString("productName"));
               product.setProductId(rs.getInt("productID"));
               product.setProductDescription(rs.getString("productDescription"));
               product.setProductImage(rs.getString("productImage"));
               product.setProductPrice(rs.getDouble("productPrice"));

               cart.setCartID(rs.getInt("cartID"));
               cart.setProduct(product);
            }
            db.closeConnection(con);
            return cart.getProducts();
        }   catch(SQLException e){
            e.printStackTrace();
            return null;
    }
       
        
        
    }
       
    }
   

    


