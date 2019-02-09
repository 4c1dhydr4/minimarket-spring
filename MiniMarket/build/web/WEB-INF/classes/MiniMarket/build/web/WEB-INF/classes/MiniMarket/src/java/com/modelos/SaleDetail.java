package com.modelos;

public class SaleDetail {
    private int idSaleDetail;
    private int idProducto;
    private int Quantity;
    private String ProductCode;
    private String ProductName;

    public SaleDetail() {
    }

    public SaleDetail(int idSaleDetail, int idProducto, int Quantity) {
        this.idSaleDetail = idSaleDetail;
        this.idProducto = idProducto;
        this.Quantity = Quantity;
    }

    public SaleDetail(int idSaleDetail, int idProducto, int Quantity, String ProductCode, String ProductName) {
        this.idSaleDetail = idSaleDetail;
        this.idProducto = idProducto;
        this.Quantity = Quantity;
        this.ProductCode = ProductCode;
        this.ProductName = ProductName;
    }

    public int getIdSaleDetail() {
        return idSaleDetail;
    }

    public void setIdSaleDetail(int idSaleDetail) {
        this.idSaleDetail = idSaleDetail;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public String getProductCode() {
        return ProductCode;
    }

    public void setProductCode(String ProductCode) {
        this.ProductCode = ProductCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }
    
    
}
