package com.dao;
import com.modelos.Product;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
}