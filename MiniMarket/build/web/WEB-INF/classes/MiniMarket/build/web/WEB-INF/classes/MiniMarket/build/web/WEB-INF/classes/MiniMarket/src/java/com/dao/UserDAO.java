package com.dao;
import com.modelos.User;
import com.util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
    public List<User> listarUsers() {
        List<User> users = null;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT idUser, firstname + ' ' + lastname AS "
                    + "UserName FROM Users WHERE active='Y'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            users = new ArrayList<>();
            while(rs.next()) {
                User user = new User();
                user.setIdUser(rs.getInt(1));
                user.setFirstname(rs.getString(2));
                users.add(user);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    } 
}