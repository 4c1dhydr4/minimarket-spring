package com.modelos;
import com.dao.ProductDAO;
import com.modelos.SaleDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sale {
    private int idSale;
    private int idUser;
    private int idClient;
    private String SaleCode;
    private String SaleDate;
    private float Total;
    private List<SaleDetail> detail;
    private String SalesMan;
    private String ClientName;

    public Sale() {
        this.detail = new ArrayList<SaleDetail>();
    }

    public Sale(int idSale, int idUser, int idClient, String SaleCode, String SaleDate, float Total) {
        this.idSale = idSale;
        this.idUser = idUser;
        this.idClient = idClient;
        this.SaleCode = SaleCode;
        this.SaleDate = SaleDate;
        this.Total = Total;
        this.detail = new ArrayList<SaleDetail>();
    }

    public Sale(int idSale, int idUser, int idClient, String SaleCode, String SaleDate, float Total, List<SaleDetail> detail, String SalesMan, String ClientName) {
        this.idSale = idSale;
        this.idUser = idUser;
        this.idClient = idClient;
        this.SaleCode = SaleCode;
        this.SaleDate = SaleDate;
        this.Total = Total;
        this.detail = detail;
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
        return detail;
    }

    public void setDetail(List<SaleDetail> saleDetail) {
        ProductDAO ProductDAO = new ProductDAO();
        this.detail = saleDetail;
        float total = 0;
        for (Iterator<SaleDetail> iterator = saleDetail.iterator(); iterator.hasNext();) {
            SaleDetail next = iterator.next();
            float price = ProductDAO.getPriceById(next.getIdProducto());
            total += (price*next.getQuantity());
        }
        this.Total = total;
    }
       
    public void addDetail(SaleDetail saleDetail) {
        this.detail.add(saleDetail);
    }  
}
