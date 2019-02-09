package com.modelos;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class Conectar
{ 
    public DriverManagerDataSource Conectar()
    {
        DriverManagerDataSource DataSource = new DriverManagerDataSource();
        DataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DataSource.setUrl("jdbc:sqlserver://NEURON1\\LOCALHOST;databaseName=FinalSolWeb;");
//        DataSource.setUrl("jdbc:sqlserver://NEURONII\\LOCALHOST;databaseName=FinalSolWeb;");
        DataSource.setUsername("sa");
        DataSource.setPassword("sql");
        return DataSource;
    }
}
