package com.dao;
import com.modelos.Product;
import com.modelos.SaleDetail;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductDAO {
    public List<Product> listarProductosForDetail() {
        List<Product> products = null;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT idProduct, ProductCode, QuantityPerUnit, "
                    + "UnitPrice, UnitsInStock, ProductName FROM Product "
                    + "WHERE Discontinued='N'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            products = new ArrayList<>();
            while(rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getInt(1));
                product.setProductCode(rs.getString(2));
                product.setQuantityPerUnit(rs.getString(3));
                product.setUnitPrice(rs.getFloat(4));
                product.setUnitsInStock(rs.getInt(5));
                product.setProductName(rs.getString(6));
                product.setDetailQuantity(0);
                product.setDetailAdd(false);
                products.add(product);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    } 
    
    public static float getPriceById(int idProduct){
        float price = 0;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT TOP 1 UnitPrice FROM Product WHERE idProduct='"+
                    idProduct + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);            
            while(rs.next()) {
                price = rs.getFloat(1);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return price;
    }
    
    public List<SaleDetail> products2detail(List<Product> products){
        List <SaleDetail> detalle = new ArrayList();
        int index = 0;
        for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
            Product next = iterator.next();
            SaleDetail detail = SaleDetail.product2detail(next, index);
            detalle.add(detail);
            index++;
        }
        return detalle;
    }
    
}