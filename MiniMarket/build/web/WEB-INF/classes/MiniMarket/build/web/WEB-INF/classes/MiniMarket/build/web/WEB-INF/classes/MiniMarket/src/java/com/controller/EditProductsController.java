package com.controller;
import com.modelos.Conectar;
import com.modelos.Product;
import com.validations.ProductValidation;
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

public class EditProductsController 
{
    ProductValidation ProductValidation;
    private JdbcTemplate jdbcTemplate;
    
    public EditProductsController() 
    {
        this.ProductValidation = new ProductValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idProduct = request.getParameter("idProduct");
        Product Datos = this.selectProduct(idProduct);
        MAV.setViewName("ProductEdit");
        MAV.addObject("Product",new Product(
                Integer.parseInt(idProduct), 
                Datos.getProductCode(), 
                Datos.getProductName(), 
                Datos.getQuantityPerUnit(),
                Datos.getUnitPrice(),
                Datos.getUnitsInStock()
        ));
        return MAV;
    }    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Product") Product p,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.ProductValidation.validate(p, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            String idProduct = request.getParameter("idProduct");
            Product Datos = this.selectProduct(idProduct);
            MAV.setViewName("ProductEdit");
            MAV.addObject("Product",new Product(
                Integer.parseInt(idProduct), 
                Datos.getProductCode(), 
                Datos.getProductName(), 
                Datos.getQuantityPerUnit(),
                Datos.getUnitPrice(),
                Datos.getUnitsInStock()
            ));
            return MAV;
        }
        else
        {
            int idProduct = Integer.parseInt(request.getParameter("idProduct"));
            this.jdbcTemplate.update(
                    "UPDATE Product SET ProductCode = ?, ProductName=?, " + 
                        "QuantityPerUnit=?, UnitPrice=?, UnitsInStock=? " + 
                        "WHERE idProduct=?",
                    p.getProductCode(), p.getProductName(), p.getQuantityPerUnit(), 
                    p.getUnitPrice(), p.getUnitsInStock(), idProduct);
            return new ModelAndView("redirect:/ProductHome.htm");
        }
    }
    
    public Product selectProduct(String idProduct) 
    {
        final Product Product = new Product();
        String Quer = "SELECT idProduct, ProductCode, ProductName, " + 
                "QuantityPerUnit, UnitPrice, UnitsInStock FROM Product " + 
                "WHERE idProduct='"+idProduct+"'";
        return (Product) jdbcTemplate.query
        (
                Quer, new ResultSetExtractor<Product>() 
            {
                public Product extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Product.setIdProduct(rs.getInt("idProduct"));
                        Product.setProductCode(rs.getString("ProductCode"));
                        Product.setProductName(rs.getString("ProductName"));
                        Product.setQuantityPerUnit(rs.getString("QuantityPerUnit"));
                        Product.setUnitPrice(rs.getFloat("UnitPrice"));
                        Product.setUnitsInStock(rs.getInt("UnitsInStock"));
                    }
                    return Product;
                }
            }
        );
    }
}