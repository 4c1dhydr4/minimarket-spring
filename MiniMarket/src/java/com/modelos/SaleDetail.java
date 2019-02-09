package com.modelos;

import com.dao.ProductDAO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SaleDetail {
    private int idSaleDetail;
    private int idProducto;
    private int Quantity;
    private String ProductCode;
    private String ProductName;
    float price;
    private boolean Add;
    private int index;

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
        this.Add = Add;
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

    public boolean isAdd() {
        return Add;
    }

    public void setAdd(boolean Add) {
        this.Add = Add;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public float getPrice() {
        ProductDAO ProductDAO = new ProductDAO();
        float price = ProductDAO.getPriceById(this.idProducto);
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public static SaleDetail product2detail(Product product, int index){
        SaleDetail detail = new SaleDetail();
        detail.setIdProducto(product.getIdProduct());
        detail.setProductCode(product.getProductCode());
        detail.setProductName(product.getProductName());
        detail.setQuantity(0);
        detail.setAdd(false);
        detail.setIndex(index);
        return detail;
    }  
    public static List<SaleDetail> SaveDetail(List <Product> products, List<SaleDetail> postDetail){
        List<SaleDetail> detail = new ArrayList();
        int i=0;
        for (Iterator<SaleDetail> iterator = postDetail.iterator(); iterator.hasNext();) {
            SaleDetail actualDetail = iterator.next();
            SaleDetail oneDetail = new SaleDetail();
            if(actualDetail.isAdd()){
                oneDetail.setIdProducto(products.get(i).getIdProduct());
                oneDetail.setProductCode(products.get(i).getProductCode());
                oneDetail.setProductName(products.get(i).getProductName());
                oneDetail.setQuantity(actualDetail.getQuantity());
                detail.add(oneDetail);
            }
            i++;
        }
        return detail;
    }
}
