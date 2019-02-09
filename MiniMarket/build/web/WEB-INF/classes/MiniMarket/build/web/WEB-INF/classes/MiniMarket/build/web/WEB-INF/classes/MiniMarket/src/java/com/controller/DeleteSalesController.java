package com.controller;
import com.modelos.Conectar;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

public class DeleteSalesController
{
    private JdbcTemplate jdbcTemplate;
    public DeleteSalesController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping("SaleDelete.htm")
    public ModelAndView home(HttpServletRequest request) 
    {
        String idSale = request.getParameter("idSale");
        this.jdbcTemplate.update("UPDATE Sale SET Deleted='Y' WHERE idSale=?", idSale);
        return new ModelAndView("redirect:/SaleHome.htm");
    }
}