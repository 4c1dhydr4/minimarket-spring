package com.controller;
import com.modelos.Conectar;
import com.modelos.Client;
import com.validations.ClientValidation;
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

public class EditClientsController 
{
    ClientValidation ClientValidation;
    private JdbcTemplate jdbcTemplate;
    
    public EditClientsController() 
    {
        this.ClientValidation = new ClientValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idClient = request.getParameter("idClient");
        Client Datos = this.selectClient(idClient);
        MAV.setViewName("ClientEdit");
        MAV.addObject("Client",new Client(Integer.parseInt(idClient), 
                Datos.getClientCode(), 
                Datos.getFirstName(), 
                Datos.getLastName(),
                Datos.getRegisterDate()));
        return MAV;
    }    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Client") Client c,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
        )
    {
        this.ClientValidation.validate(c, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            String idClient = request.getParameter("idClient");
            Client Datos = this.selectClient(idClient);
            MAV.setViewName("ClientEdit");
            MAV.addObject("Client",new Client(
                    Integer.parseInt(idClient), 
                    Datos.getClientCode(), 
                    Datos.getFirstName(), 
                    Datos.getLastName(),
                    Datos.getRegisterDate()));
            return MAV;
        }
        else
        {
            int idClient = Integer.parseInt(request.getParameter("idClient"));
            this.jdbcTemplate.update(
                    "UPDATE Client SET ClientCode = ?, FirstName = ?, "
                    + "LastName = ?, RegisterDate = ? WHERE idClient=?",
                    c.getClientCode(), c.getFirstName(), c.getLastName(), 
                    c.getRegisterDate(), idClient);
            return new ModelAndView("redirect:/ClientHome.htm");
        }
    }
    
    public Client selectClient(String idClient) 
    {
        final Client Client = new Client();
        String Quer = "SELECT idClient, ClientCode, FirstName, LastName, " + 
                "RegisterDate, Discontinued FROM Client WHERE idClient = '" + 
                idClient + "'";
        return (Client) jdbcTemplate.query
        (
                Quer, new ResultSetExtractor<Client>() 
            {
                public Client extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Client.setIdClient(rs.getInt("idClient"));
                        Client.setClientCode(rs.getString("ClientCode"));
                        Client.setFirstName(rs.getString("FirstName"));
                        Client.setLastName(rs.getString("LastName"));
                        Client.setRegisterDate(rs.getString("RegisterDate"));
                    }
                    return Client;
                }
            }
        );
    }
}