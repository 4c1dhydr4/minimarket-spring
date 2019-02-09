package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {
    public static Connection getConexion(){
        Connection cnx = null;
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cnx = DriverManager.getConnection("jdbc:sqlserver://localhost;"
//            cnx = DriverManager.getConnection("jdbc:sqlserver://NEURONII\\LOCALHOST"
            + "databaseName=FinalSolWeb;user=sa;password=12345678");
        }catch (Exception e){
            System.out.println("" + e.toString());
        }
        return cnx;
    }
}
