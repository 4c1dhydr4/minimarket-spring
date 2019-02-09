package com.dao;
import com.modelos.Conectar;
import com.modelos.Product;
import com.modelos.Ticket;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TicketDAO {
    private JdbcTemplate jdbcTemplate;

    public TicketDAO(){
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    public Ticket getTicket(String idSale){
        final Ticket Ticket = new Ticket();
        String Quer = "SELECT c.FirstName + ' ' + c.LastName as ClientName, u.firstname + ' ' + u.lastname as UserName," +
                    " s.SaleCode, s.SaleDate, s.Total " +
                    " FROM Client c, Sale s, Users u WHERE s.idClient=c.idClient AND s.idUser=u.idUser AND idSale='"+idSale+"'";
        return (Ticket) jdbcTemplate.query
        (
            Quer, new ResultSetExtractor<Ticket>() 
            {
                public Ticket extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Ticket.setClientName(rs.getString("ClientName"));
                        Ticket.setSalesMan(rs.getString("UserName"));
                        Ticket.setSaleCode(rs.getString("SaleCode"));
                        Ticket.setSaleDate(rs.getString("SaleDate"));
                        Ticket.setTotal(rs.getString("Total"));
                    }
                    return Ticket;
                }
            } 
        );
    }
    
    public List<Product> getTicketDetail(String idSale){
        List<Product> products = null;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT p.ProductCode, p.ProductName, p.UnitPrice, sd.Quantity " +
                        "FROM SaleDetail sd, Product p WHERE p.idProduct=sd.idProduct AND " +
                        "sd.idSale='"+idSale+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            products = new ArrayList<>();
            while(rs.next()) {
                Product product = new Product();
                product.setProductCode(rs.getString("ProductCode"));
                product.setProductName(rs.getString("ProductName"));
                product.setUnitPrice(rs.getFloat("UnitPrice"));
                product.setDetailQuantity(rs.getInt("Quantity"));
                products.add(product);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
    
}
