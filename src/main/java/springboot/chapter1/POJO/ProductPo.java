package springboot.chapter1.POJO;


import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @Author: zkk
 * @Description:
 * @Date: Created in 8:20 2019/7/1
 * @Modified By:
 */
@Alias("product")
public class ProductPo implements Serializable {
    private static final Long serialVersionUID = 1L;
    private Long id;
    private String productName;
    private int stock;
    private double price;
    private int version;
    private String note;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}