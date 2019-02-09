package com.controller;
import com.modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class HomeUsersController 
{
    private JdbcTemplate jdbcTemplate;
    
    public HomeUsersController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("UserHome.htm")
    public ModelAndView Home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "SELECT * FROM Users WHERE active='Y';";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("UserHome");
        return MAV;
    }
}