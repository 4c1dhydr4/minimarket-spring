package com.modelos;

public class Product {
    private int idProduct;
    private String ProductCode;
    private String ProductName;
    private String QuantityPerUnit;
    private float UnitPrice;
    private int UnitsInStock;
    private int DetailQuantity;
    private boolean DetailAdd;

    public Product() {
    }

    public Product(int idProduct, String ProductCode, String ProductName, String QuantityPerUnit, float UnitPrice, int UnitsInStock) {
        this.idProduct = idProduct;
        this.ProductCode = ProductCode;
        this.ProductName = ProductName;
        this.QuantityPerUnit = QuantityPerUnit;
        this.UnitPrice = UnitPrice;
        this.UnitsInStock = UnitsInStock;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public String getQuantityPerUnit() {
        return QuantityPerUnit;
    }

    public void setQuantityPerUnit(String QuantityPerUnit) {
        this.QuantityPerUnit = QuantityPerUnit;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public int getUnitsInStock() {
        return UnitsInStock;
    }

    public void setUnitsInStock(int UnitsInStock) {
        this.UnitsInStock = UnitsInStock;
    }

    public int getDetailQuantity() {
        return DetailQuantity;
    }
    
    public String getDetailQuantityString() {
        return String.valueOf(getDetailQuantity());
    }

    public void setDetailQuantity(int DetailQuantity) {
        this.DetailQuantity = DetailQuantity;
    }

    public boolean isDetailAdd() {
        return DetailAdd;
    }

    public void setDetailAdd(boolean DetailAdd) {
        this.DetailAdd = DetailAdd;
    }
    
    public float getImporte(){
        return this.UnitPrice*this.DetailQuantity;
    }
    
}
