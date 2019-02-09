package com.controller;
import com.modelos.Conectar;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

public class HomeSalesController 
{
    private JdbcTemplate jdbcTemplate;
    
    public HomeSalesController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("SaleHome.htm")
    public ModelAndView Home()
    {
        ModelAndView MAV = new ModelAndView();
        String SQL = "SELECT s.idSale, s.SaleCode, u.firstname + ' ' +  u.lastname AS SalesMan, " + 
                "s.SaleDate, c.FirstName + ' ' + c.LastName AS ClientName, " + 
                "s.Total FROM Sale s, Client c, Users u WHERE Deleted='N' " + 
                "AND c.idClient=s.idClient AND u.idUser=s.idUser";
        List Dato = this.jdbcTemplate.queryForList(SQL);
        MAV.addObject("Datos",Dato);
        MAV.setViewName("SaleHome");

        return MAV;
    }
}