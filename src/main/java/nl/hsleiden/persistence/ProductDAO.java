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
import nl.hsleiden.model.Product;

/**
 *
 * @author abdoul
 */

public class ProductDAO {
    private final Database db;
    private List<Product> products;
    
    public ProductDAO(){
        db = new Database();
        products = new ArrayList<>();
        
        
       
    }
    
    public void add(Product product) throws SQLException{
        
            
                Connection con = db.getConnection();
                PreparedStatement ps = con.prepareStatement("insert into Product(productName,productDescription,productImage,productPrice) values(?,?,?,?);");
                ps.setString(1, product.getProductName().trim());
                ps.setString(2,product.getProductDescription().trim());
                ps.setString(3, product.getProductImage().trim());
                ps.setDouble(4, product.getProductPrice());
                ps.execute();
                
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
        

        
    
    
    public List getAll(){
        
        products.clear();
        
        try{
            Connection con = db.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from Product");
            Product product;
            while(rs.next()){
               product = new Product();
               product.setProductName(rs.getString("productName"));
               System.out.println(product.getProductName());
               product.setProductId(rs.getInt("productID"));
               product.setProductDescription(rs.getString("productDescription"));
               product.setProductImage(rs.getString("productImage"));
               product.setProductPrice(rs.getDouble("productPrice"));
               products.add(product);
            }
            db.closeConnection(con);
            return products;
        }   catch(SQLException e){
            e.printStackTrace();
            return null;
    }
    }
}
