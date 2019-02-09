package com.controller;
import com.modelos.Conectar;
import com.modelos.Client;
import com.util.Tools;
import com.validations.ClientValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("ClientAdd.htm")
public class AddClientsController {
    ClientValidation ClientValidation;
    private JdbcTemplate jdbcTemplate;

    public AddClientsController() 
    {
        this.ClientValidation = new ClientValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("ClientAdd");
            Client client = new Client();
            Client latestClient = selectLatestClient();
            Tools t = new Tools();
            String code = t.getCode(latestClient.getClientCode());
            client.setClientCode(code);
            MAV.addObject("Client", client);
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("Client") Client c,
                BindingResult result,
                SessionStatus status
        )
    {
        this.ClientValidation.validate(c, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("ClientAdd");
            MAV.addObject("Client", new Client());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "INSERT INTO Client VALUES(?, ?, ?, ?, 'N');",
                c.getClientCode(), c.getFirstName(), c.getLastName(), c.getRegisterDate()
            );
            return new ModelAndView("redirect:/ClientHome.htm");
        }
    }
    public Client selectLatestClient(){
       final Client Client = new Client();
       String Quer = "SELECT TOP 1 * FROM Client ORDER BY idClient DESC";
       return (Client) jdbcTemplate.query
        (
            Quer, new ResultSetExtractor<Client>() 
            {
                public Client extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        Client.setClientCode(rs.getString("ClientCode"));
                    }
                    return Client;
                }
            } 
        );
    }
        
}
