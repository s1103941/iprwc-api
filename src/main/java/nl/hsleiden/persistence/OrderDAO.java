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
import nl.hsleiden.model.Order;
import nl.hsleiden.model.Product;


public class OrderDAO {
    
    private ArrayList<Order> allOrders;
    private final Database db;
    
    public OrderDAO(){
        allOrders = new ArrayList<>();
        db = new Database();
    }
    
    public void addOrder(ArrayList<Product> allProducts){
        
           System.out.println("Hier kom ik tweede");
        
        int hoeveelheid = allProducts.size();
        double totalePrijs = 0;
        
        for( Product p : allProducts){
            totalePrijs += p.getProductPrice();
        }
        
        Order order = new Order();
        order.setAantalProducten(hoeveelheid);
        order.setTotalePrijs(totalePrijs);
        
     
        insertOrder(order);
        
    }
    
    public void insertOrder(Order order){
        
        
        try{
        Connection con = db.getConnection();
        PreparedStatement ps = con.prepareStatement("insert into Orders(producten,prijs) values(?,?);");
        ps.setInt(1, order.getAantalProducten());
        ps.setDouble(2,order.getTotalePrijs());
        ps.execute();
        }catch(SQLException e){
            
        }
    }
    
    public ArrayList getAll(){
        allOrders.clear();
        
         try{
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Orders");
            Order order;
            while(rs.next()){
               order = new Order();
               order.setOrderID(rs.getInt("id"));
               order.setAantalProducten(rs.getInt("producten"));
               order.setTotalePrijs(rs.getDouble("prijs"));
               allOrders.add(order);
            }
            db.closeConnection(con);
            return allOrders;
        }   catch(SQLException e){
            e.printStackTrace();
            return null;
    }
    }
    
}
