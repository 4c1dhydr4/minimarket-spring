package com.dao;
import com.modelos.SaleDetail;
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

public class SaleDetailDAO {
    public List<SaleDetail> listarSaleDetail(String idSale) {
        List<SaleDetail> saleDetails = null;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT s.idSaleDetail, p.idProduct, p.ProductCode, p.ProductName, s.Quantity  FROM SaleDetail s, " +
                         "Product p WHERE p.idProduct=s.idProduct AND s.idSale='"+idSale + "'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            saleDetails = new ArrayList<>();
            while(rs.next()) {
                SaleDetail saleDetail = new SaleDetail();
                saleDetail.setIdSaleDetail(rs.getInt(1));
                saleDetail.setIdProducto(rs.getInt(2));
                saleDetail.setProductCode(rs.getString(3));
                saleDetail.setProductName(rs.getString(4));
                saleDetail.setQuantity(rs.getInt(5));
                saleDetails.add(saleDetail);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saleDetails;
    } 
}