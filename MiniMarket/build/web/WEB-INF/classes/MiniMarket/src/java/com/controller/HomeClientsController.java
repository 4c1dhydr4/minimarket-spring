package com.controller;
import com.modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class HomeClientsController 
{
    private JdbcTemplate jdbcTemplate;
    
    public HomeClientsController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("ClientHome.htm")
    public ModelAndView Home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "SELECT * FROM Client WHERE Discontinued='N'";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("ClientHome");
        return MAV;
    }
}