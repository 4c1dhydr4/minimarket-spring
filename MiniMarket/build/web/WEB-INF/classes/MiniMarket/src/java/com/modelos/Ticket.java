package com.modelos;

import java.util.List;

public class Ticket {
    private String clientName;
    private String salesMan;
    private String saleCode;
    private String saleDate;
    private String total;
    private List<Product> products;

    public Ticket() {
    }

    public Ticket(String clientName, String salesMan, String saleCode, String saleDate, String total) {
        this.clientName = clientName;
        this.salesMan = salesMan;
        this.saleCode = saleCode;
        this.saleDate = saleDate;
        this.total = total;
    }
    
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSalesMan() {
        return salesMan;
    }

    public void setSalesMan(String salesMan) {
        this.salesMan = salesMan;
    }

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
}
