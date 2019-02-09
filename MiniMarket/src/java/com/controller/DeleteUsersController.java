package com.controller;
import com.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteUsersController
{
    private JdbcTemplate jdbcTemplate;
    public DeleteUsersController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("UserDelete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        String idUser = request.getParameter("idUser");
        this.jdbcTemplate.update("UPDATE Users SET active='N' WHERE idUser=?", idUser);
        return new ModelAndView("redirect:/UserHome.htm");
    }
}