package com.modelos;

public class Client {
    private int idClient;
    private String ClientCode;
    private String FirstName;
    private String LastName;
    private String RegisterDate;

    public Client() {
    }

    public Client(int idClient, String ClientCode, String FirstName, String LastName, String RegisterDate) {
        this.idClient = idClient;
        this.ClientCode = ClientCode;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.RegisterDate = RegisterDate;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getClientCode() {
        return ClientCode;
    }

    public void setClientCode(String ClientCode) {
        this.ClientCode = ClientCode;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getRegisterDate() {
        return RegisterDate;
    }

    public void setRegisterDate(String RegisterDate) {
        this.RegisterDate = RegisterDate;
    }
    
    
}
