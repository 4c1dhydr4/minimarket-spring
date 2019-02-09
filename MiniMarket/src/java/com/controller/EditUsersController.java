package com.controller;
import com.modelos.Conectar;
import com.modelos.User;
import com.validations.UserValidation;
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

public class EditUsersController 
{
    UserValidation UserValidation;
    private JdbcTemplate jdbcTemplate;
    
    public EditUsersController() 
    {
        this.UserValidation = new UserValidation();
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        String idUser = request.getParameter("idUser");
        User Datos = this.selectUser(idUser);
        MAV.setViewName("UserEdit");
        MAV.addObject("User",new User(
                Integer.parseInt(idUser), 
                Datos.getUsername(), 
                Datos.getPassword(),
                Datos.getFirstname(),
                Datos.getLastname(),
                Datos.getEmail(),
                Datos.getAddress(),
                Datos.getPhone(),
                Datos.getTypeUser()
        ));
        return MAV;
    }    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form
        (
                @ModelAttribute("User") User u,
                BindingResult result,
                SessionStatus status,
                HttpServletRequest request
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
            String idUser = request.getParameter("idUser");
            User Datos = this.selectUser(idUser);
            MAV.setViewName("UserEdit");
            MAV.addObject("User",new User(
                Integer.parseInt(idUser), 
                Datos.getUsername(), 
                Datos.getPassword(),
                Datos.getFirstname(),
                Datos.getLastname(),
                Datos.getEmail(),
                Datos.getAddress(),
                Datos.getPhone(),
                Datos.getTypeUser()
            ));
            return MAV;
        }
        else
        {
            int idUser = Integer.parseInt(request.getParameter("idUser"));
            this.jdbcTemplate.update(
                    "UPDATE Users SET username=?, password=?, " + 
                            "firstname=?, lastname=?, email=?, " + 
                            "address=?, phone=?, typeUser=? WHERE idUser=?",
                    u.getUsername(), u.getPassword(), u.getFirstname(), 
                    u.getLastname(), u.getEmail(), u.getAddress(), 
                    u.getPhone(), u.getTypeUser(), idUser);
            return new ModelAndView("redirect:/UserHome.htm");
        }
    }
    
    public User selectUser(String idUser) 
    {
        final User User = new User();
        String Quer = "SELECT idUser, username, password, firstname, lastname, " + 
                "email, address, phone, typeUser FROM Users " + 
                "WHERE idUser='"+idUser+"'";
        return (User) jdbcTemplate.query
        (
                Quer, new ResultSetExtractor<User>() 
            {
                public User extractData(ResultSet rs) throws SQLException, DataAccessException
                {
                    if (rs.next())
                    {
                        User.setIdUser(rs.getInt("idUser"));
                        User.setUsername(rs.getString("username"));
                        User.setPassword(rs.getString("password"));
                        User.setFirstname(rs.getString("firstname"));
                        User.setLastname(rs.getString("lastname"));
                        User.setEmail(rs.getString("email"));
                        User.setAddress(rs.getString("address"));
                        User.setPhone(rs.getInt("phone"));
                        User.setTypeUser(rs.getString("typeUser"));
                    }
                    return User;
                }
            }
        );
    }
}