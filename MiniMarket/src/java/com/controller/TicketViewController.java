package com.controller;
import com.dao.TicketDAO;
import com.modelos.Conectar;
import com.modelos.Product;
import com.modelos.Ticket;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class TicketViewController {
    private JdbcTemplate jdbcTemplate;
    
    public TicketViewController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView Ticket(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idSale = request.getParameter("idSale");
        TicketDAO TicketDAO = new TicketDAO();
        MAV.addObject("Ticket", TicketDAO.getTicket(idSale));
        MAV.addObject("TicketDetail",TicketDAO.getTicketDetail(idSale));
        MAV.setViewName("TicketView");
        return MAV;
    }
}
