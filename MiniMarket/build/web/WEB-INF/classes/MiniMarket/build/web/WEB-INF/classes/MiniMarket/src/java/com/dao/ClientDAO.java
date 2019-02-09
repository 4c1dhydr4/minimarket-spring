package com.dao;
import com.modelos.Client;
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

public class ClientDAO {
    public List<Client> listarClient() {
        List<Client> clients = null;
        try {
            Connection cnx = ConexionDB.getConexion();
            String sql = "SELECT idClient, FirstName + ' ' + LastName "
                    + "AS ClientName FROM Client WHERE Discontinued='N'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
            clients = new ArrayList<>();
            while(rs.next()) {
                Client client = new Client();
                client.setIdClient(rs.getInt(1));
                client.setFirstName(rs.getString(2));
                clients.add(client);
            }
            rs.close();st.close();cnx.close();
        } catch (SQLException ex) {
            Logger.getLogger(SaleDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clients;
    } 
}