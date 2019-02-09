package com.controller;
import com.modelos.Conectar;
import com.modelos.Sale;
import com.modelos.Product;
import com.modelos.SaleDetail;
import com.dao.ProductDAO;
import com.dao.ClientDAO;
import com.dao.UserDAO;
import com.util.Tools;
import com.validations.SaleValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
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
@RequestMapping("SaleAdd.htm")
public class AddSalesController {
    SaleValidation SaleValidation;
    private JdbcTemplate jdbcTemplate;

    public AddSalesController() 
    {
        this.SaleValidation = new SaleValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("SaleAdd");
            Sale sale = new Sale();
            Sale latestSale = selectLatestSale();
            Tools t = new Tools();
            String code = t.getCode(latestSale.getSaleCode());
            sale.setSaleCode(code);
            ProductDAO productDAO = new ProductDAO();
            ClientDAO clientDAO = new ClientDAO();
            UserDAO userDAO = new UserDAO();
            MAV.addObject("Sale", sale);
            MAV.addObject("Users", userDAO.listarUsers());
            MAV.addObject("Clients", clientDAO.listarClient());
            MAV.addObject("Products", productDAO.listarProductosForDetail());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Sale") Sale s,
                BindingResult result,
                SessionStatus status
        )
    {
        this.SaleValidation.validate(s, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("SaleAdd");
            MAV.addObject("Sale", new Sale());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "INSERT INTO Sale VALUES(?, ?, ?, ?, ?, 'N');",
                s.getIdUser(), s.getIdClient(), s.getSaleCode(), 
                s.getSaleDate(), s.getTotal()
            );
            return new ModelAndView("redirect:/SaleHome.htm");
        }
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
                        Sale.setSaleCode(rs.getString("SaleCode"));
                    }
                    return Sale;
                }
            } 
        );
    }
        
}
