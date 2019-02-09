package com.controller;
import com.modelos.Conectar;
import com.modelos.Product;
import com.util.Tools;
import com.validations.ProductValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@RequestMapping("ProductAdd.htm")
public class AddProductsController {
    ProductValidation ProductValidation;
    private JdbcTemplate jdbcTemplate;

    public AddProductsController() 
    {
        this.ProductValidation = new ProductValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("ProductAdd");
            Product product = new Product();
            Product latestProduct = selectLatestProduct();
            Tools t = new Tools();
            String code = t.getCode(latestProduct.getProductCode());
            product.setProductCode(code);
            MAV.addObject("Product", product);
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Product") Product p,
                BindingResult result,
                SessionStatus status
        )
    {
        this.ProductValidation.validate(p, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("ProductAdd");
            MAV.addObject("Product", new Product());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "INSERT INTO Product VALUES(?, ?, ?, ?, ?, 'N');",
                p.getProductCode(), p.getProductName(), p.getQuantityPerUnit(), 
                p.getUnitPrice(), p.getUnitsInStock()
            );
            return new ModelAndView("redirect:/ProductHome.htm");
        }
    }
    public Product selectLatestProduct(){
       final Product Product = new Product();
       String Quer = "SELECT TOP 1 * FROM Product ORDER BY idProduct DESC";
       return (Product) jdbcTemplate.query
        (
            Quer, new ResultSetExtractor<Product>() 
            {
                public Product extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Product.setProductCode(rs.getString("ProductCode"));
                    }
                    return Product;
                }
            } 
        );
    }
        
}
