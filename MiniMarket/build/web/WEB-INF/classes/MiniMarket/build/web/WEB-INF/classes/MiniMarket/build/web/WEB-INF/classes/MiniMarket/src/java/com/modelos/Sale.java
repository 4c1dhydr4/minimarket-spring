package com.modelos;
import com.modelos.SaleDetail;
import java.util.List;

public class Sale {
    private int idSale;
    private int idUser;
    private int idClient;
    private String SaleCode;
    private String SaleDate;
    private float Total;
    private List<SaleDetail> saleDetail;
    private String SalesMan;
    private String ClientName;

    public Sale() {
    }

    public Sale(int idSale, int idUser, int idClient, String SaleCode, String SaleDate, float Total) {
        this.idSale = idSale;
        this.idUser = idUser;
        this.idClient = idClient;
        this.SaleCode = SaleCode;
        this.SaleDate = SaleDate;
        this.Total = Total;
    }

    public Sale(int idSale, int idUser, int idClient, String SaleCode, String SaleDate, float Total, List<SaleDetail> detail, String SalesMan, String ClientName) {
        this.idSale = idSale;
        this.idUser = idUser;
        this.idClient = idClient;
        this.SaleCode = SaleCode;
        this.SaleDate = SaleDate;
        this.Total = Total;
        this.saleDetail = saleDetail;
        this.SalesMan = SalesMan;
        this.ClientName = ClientName;
    }
    
    

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getSaleCode() {
        return SaleCode;
    }

    public void setSaleCode(String SaleCode) {
        this.SaleCode = SaleCode;
    }

    public String getSaleDate() {
        return SaleDate;
    }

    public void setSaleDate(String SaleDate) {
        this.SaleDate = SaleDate;
    }

    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }

    public String getSalesMan() {
        return SalesMan;
    }

    public void setSalesMan(String SalesMan) {
        this.SalesMan = SalesMan;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String ClientName) {
        this.ClientName = ClientName;
    }   

    public List<SaleDetail> getDetail() {
        return saleDetail;
    }

    public void setDetail(List<SaleDetail> saleDetail) {
        this.saleDetail = saleDetail;
    }    
    
}
