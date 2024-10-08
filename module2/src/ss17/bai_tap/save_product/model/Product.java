package ss17.bai_tap.save_product.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String idProduct;
    private String nameProduct;
    private int price;
    private String manufacturer;
    private String description;
    public Product() {}
    public Product(String idProduct, String nameProduct, int price, String manufacturer, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.manufacturer = manufacturer;
        this.description = description;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price='" + price + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
