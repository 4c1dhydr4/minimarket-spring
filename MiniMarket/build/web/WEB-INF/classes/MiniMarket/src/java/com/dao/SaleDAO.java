package com.dao;
import com.modelos.Conectar;
import com.modelos.Sale;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class SaleDAO {
    private JdbcTemplate jdbcTemplate;

    public SaleDAO(){
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    public Sale getSale(String idSale){
        final Sale Sale = new Sale();
        String Quer = "SELECT TOP 1 * FROM Sale WHERE idSale='"+idSale+"'";
        return (Sale) jdbcTemplate.query
        (
            Quer, new ResultSetExtractor<Sale>() 
            {
                public Sale extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Sale.setIdSale(rs.getInt("idSale"));
                    }
                    return Sale;
                }
            } 
        );
    }

    public Sale selectLatestSale(){
       final Sale Sale = new Sale();
       String Quer = "SELECT TOP 1 * FROM Sale ORDER BY idSale DESC";
       return (Sale) jdbcTemplate.query
        (
            Quer, new ResultSetExtractor<Sale>() 
            {
                public Sale extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Sale.setIdSale(rs.getInt("idSale"));
                    }
                    return Sale;
                }
            } 
        );
    }
}
