package com.controller;
import com.modelos.Conectar;
import com.modelos.Sale;
import com.modelos.SaleDetail;
import com.validations.SaleValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

public class EditSalesController 
{
    SaleValidation SaleValidation;
    private JdbcTemplate jdbcTemplate;
    
    public EditSalesController() 
    {
        this.SaleValidation = new SaleValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idSale = request.getParameter("idSale");
        Sale Datos = this.selectSale(idSale);
        MAV.setViewName("SaleEdit");
        MAV.addObject("Sale",new Sale(Integer.parseInt(idSale), 
                Datos.getIdUser(), 
                Datos.getIdClient(), 
                Datos.getSaleCode(),
                Datos.getSaleDate(),
                Datos.getTotal()
        ));
        return MAV;
    }    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Client") Sale s,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.SaleValidation.validate(s, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            String idSale = request.getParameter("idSale");
            Sale Datos = this.selectSale(idSale);
            MAV.setViewName("SaleEdit");
            MAV.addObject("Sale",new Sale(
                    Integer.parseInt(idSale), 
                    Datos.getIdUser(), 
                    Datos.getIdClient(), 
                    Datos.getSaleCode(),
                    Datos.getSaleDate(),
                    Datos.getTotal()
            ));
            return MAV;
        }
        else
        {
            int idSale = Integer.parseInt(request.getParameter("idSale"));
            this.jdbcTemplate.update(
                    "UPDATE Sale SET idUser=?, idClient=?, SaleCode=?, " + 
                            "SaleDate=?, Total=? WHERE idSale=?",
                    s.getIdUser(), s.getIdClient(), s.getSaleCode(), 
                    s.getSaleDate(), s.getTotal(), idSale);
            return new ModelAndView("redirect:/SaleHome.htm");
        }
    }
    
    public Sale selectSale(String idSale) 
    {
        final Sale Sale = new Sale();
        String Quer = "SELECT idSale, idUser, idClient, SaleCode, SaleDate, " + 
                "Total FROM Sale WHERE idSale='" + idSale + "'";
        return (Sale) jdbcTemplate.query
        (
                Quer, new ResultSetExtractor<Sale>() 
            {
                public Sale extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Sale.setIdSale(rs.getInt("idSale"));
                        Sale.setIdUser(rs.getInt("idUser"));
                        Sale.setIdClient(rs.getInt("idClient"));
                        Sale.setSaleCode(rs.getString("SaleCode"));
                        Sale.setSaleDate(rs.getString("SaleDate"));
                        Sale.setTotal(rs.getFloat("Total"));
                    }
                    return Sale;
                }
            }
        );
    }
}