package com.controller;
import com.modelos.Conectar;
import com.modelos.Sale;
import com.modelos.SaleDetail;
import com.dao.SaleDetailDAO;
import com.validations.SaleValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("SaleDetail.htm")
public class DetailSalesController 
{
    private JdbcTemplate jdbcTemplate;
    
    public DetailSalesController() 
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idSale = request.getParameter("idSale");
        
        Sale Sale = this.selectSale(idSale);
        MAV.setViewName("SaleDetail");
        MAV.addObject("Sale", Sale);
        
        SaleDetailDAO saleDetailDAO = new SaleDetailDAO();
        MAV.setViewName("SaleDetail");
        MAV.addObject("SalesDetails",saleDetailDAO.listarSaleDetail(idSale));
        return MAV;
    }    
    public Sale selectSale(String idSale) 
    {
        final Sale Sale = new Sale();
        String Quer = "SELECT s.SaleCode, u.firstname + ' ' + u.lastname AS SalesMan, s.SaleDate, " +
                    "c.FirstName + ' ' + c.LastName AS ClientName, s.Total " +
                    "FROM Sale s, Users u, Client c WHERE idSale='" + idSale+
                    "' AND s.idUser=u.idUser AND s.idClient=c.idClient;";
        return (Sale) jdbcTemplate.query
        (
                Quer, new ResultSetExtractor<Sale>() 
            {
                public Sale extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Sale.setSaleCode(rs.getString("SaleCode"));
                        Sale.setSalesMan(rs.getString("SalesMan"));
                        Sale.setSaleDate(rs.getString("SaleDate"));
                        Sale.setClientName(rs.getString("ClientName"));
                        Sale.setTotal(rs.getFloat("Total"));
                    }
                    return Sale;
                }
            }
        );
    }
}