package com.controller;
import com.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteClientsController
{
    private JdbcTemplate jdbcTemplate;
    public DeleteClientsController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("ClientDelete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        String idClient = request.getParameter("idClient");
        this.jdbcTemplate.update("UPDATE Client SET Discontinued='Y' WHERE idClient=?", idClient);
        return new ModelAndView("redirect:/ClientHome.htm");
    }
}