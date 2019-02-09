package com.controller;
import com.modelos.Conectar;
import com.modelos.Sale;
import com.modelos.Product;
import com.modelos.SaleDetail;
import com.dao.ProductDAO;
import com.dao.SaleDAO;
import com.dao.ClientDAO;
import com.dao.UserDAO;
import com.util.Tools;
import com.validations.SaleValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.jasper.tagplugins.jstl.ForEach;
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
            List <Product> products = productDAO.listarProductosForDetail();
            sale.setDetail(productDAO.products2detail(products));
            MAV.addObject("Sale", sale);
            MAV.addObject("Users", userDAO.listarUsers());
            MAV.addObject("Clients", clientDAO.listarClient());
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
            Sale sale = new Sale();
            Sale latestSale = selectLatestSale();
            Tools t = new Tools();
            String code = t.getCode(latestSale.getSaleCode());
            sale.setSaleCode(code);
            ProductDAO productDAO = new ProductDAO();
            ClientDAO clientDAO = new ClientDAO();
            UserDAO userDAO = new UserDAO();
            List <Product> products = productDAO.listarProductosForDetail();
            sale.setDetail(productDAO.products2detail(products));
            MAV.addObject("Sale", sale);
            MAV.addObject("Users", userDAO.listarUsers());
            MAV.addObject("Clients", clientDAO.listarClient());
            return MAV;
        }
        else
        {
            ProductDAO productDAO = new ProductDAO();
            List <Product> products = productDAO.listarProductosForDetail();
            List<SaleDetail> detail = new ArrayList();
            detail = SaleDetail.SaveDetail(products, s.getDetail());
            s.setDetail(detail);
            this.jdbcTemplate.update
            (
                "INSERT INTO Sale VALUES(?, ?, ?, ?, ?, 'N');",
                s.getIdUser(), s.getIdClient(), s.getSaleCode(), 
                s.getSaleDate(), s.getTotal()
            );
            SaleDAO saleDAO = new SaleDAO();
            int idLatestSale = saleDAO.selectLatestSale().getIdSale();
            for (Iterator<SaleDetail> iterator = detail.iterator(); iterator.hasNext();) {
                SaleDetail actualDetail = iterator.next();
                this.jdbcTemplate.update
                (
                    "INSERT INTO SaleDetail VALUES(?, ?, ?);",
                    idLatestSale, actualDetail.getIdProducto(), actualDetail.getQuantity()
                );
            }
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
