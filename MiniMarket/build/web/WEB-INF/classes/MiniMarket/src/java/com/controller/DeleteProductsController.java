package com.controller;
import com.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteProductsController
{
    private JdbcTemplate jdbcTemplate;
    public DeleteProductsController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("ProductDelete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        String idProduct = request.getParameter("idProduct");
        this.jdbcTemplate.update("UPDATE Product SET Discontinued='Y' WHERE idProduct=?", idProduct);
        return new ModelAndView("redirect:/ProductHome.htm");
    }
}