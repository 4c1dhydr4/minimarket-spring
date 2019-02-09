package com.controller;
import com.modelos.Conectar;
import com.modelos.User;
import com.util.Tools;
import com.validations.UserValidation;
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
@RequestMapping("UserAdd.htm")
public class AddUsersController {
    UserValidation UserValidation;
    private JdbcTemplate jdbcTemplate;

    public AddUsersController() 
    {
        this.UserValidation = new UserValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form()
    {
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("UserAdd");
        MAV.addObject("User", new User());
        return MAV;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("User") User u,
                BindingResult result,
                SessionStatus status
        )
    {
        if(u.getPassword() == null ? u.getPassword_match() != null : !u.getPassword().equals(u.getPassword_match())){
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("UserAdd");
            MAV.addObject("PassDoNotMatch", "La Contraseñas no Coincide");
            return MAV;   
        }
        this.UserValidation.validate(u, result);
        if(result.hasErrors())
        {
            ModelAndView MAV = new ModelAndView();
            MAV.setViewName("UserAdd");
            MAV.addObject("User", new User());
            return MAV;
        }
        else
        {
            this.jdbcTemplate.update
            (
                "INSERT INTO Users VALUES(?, ?, ?, ?, ?, ?, ?, ?, 'Y');",
                u.getUsername(), u.getPassword(), u.getFirstname(), 
                u.getLastname(), u.getEmail(), u.getAddress(), u.getPhone(), 
                u.getTypeUser()
            );
            return new ModelAndView("redirect:/UserHome.htm");
        }
    }
}
