package com.store.gen;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "products", schema = "", catalog = "webstore")
@Entity
public class ProductsEntity {
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    @TableGenerator(table = "id_table", name = "AppProductIdTable",
            allocationSize = 1000, initialValue = 0, pkColumnName = "pk",
            valueColumnName = "value", pkColumnValue = "app_products")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AppProductIdTable")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String title;

    @javax.persistence.Column(name = "title")
    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String description;

    @javax.persistence.Column(name = "description")
    @Basic
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private BigDecimal price;

    @javax.persistence.Column(name = "price")
    @Basic
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    private Integer quantity;

    @javax.persistence.Column(name = "quantity")
    @Basic
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (quantity != null ? !quantity.equals(that.quantity) : that.quantity != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        return result;
    }
}
