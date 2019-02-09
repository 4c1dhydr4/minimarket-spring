package com.controller;
import com.modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class HomeProductsController 
{
    private JdbcTemplate jdbcTemplate;
    
    public HomeProductsController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("ProductHome.htm")
    public ModelAndView Home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "SELECT * FROM Product WHERE Discontinued='N'";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("ProductHome");
        return MAV;
    }
}