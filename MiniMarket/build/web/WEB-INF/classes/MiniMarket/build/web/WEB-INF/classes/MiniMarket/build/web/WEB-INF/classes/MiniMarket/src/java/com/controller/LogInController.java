package com.controller;
import com.modelos.Conectar;
import com.modelos.User;
import com.validations.UserValidation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class LogInController {
    private JdbcTemplate jdbcTemplate;
    
    public LogInController()
    {
        Conectar Con = new Conectar();
        this.jdbcTemplate = new JdbcTemplate(Con.Conectar());
    }
    
    @RequestMapping(method = RequestMethod.GET) 
    public ModelAndView form(HttpServletRequest request)
    {
        ModelAndView MAV = new ModelAndView();
        MAV.setViewName("Login");
        MAV.addObject("User",new User());
        return MAV;
    } 
    public User selectUser(String username) 
       {
           final User User = new User();
           String Quer = "SELECT * FROM Users WHERE username='"+username+"'";
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
