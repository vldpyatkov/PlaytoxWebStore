package com.store.gen;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: makros
 * Date: 12/15/13
 * Time: 12:28 AM
 * To change this template use File | Settings | File Templates.
 */
@javax.persistence.Table(name = "purchase", schema = "", catalog = "webstore")
@Entity
public class PurchaseEntity {
    private int id;

    @javax.persistence.Column(name = "id")
    @Id
    @TableGenerator(table = "id_table", name = "AppPurchaseIdTable",
            allocationSize = 1000, initialValue = 0, pkColumnName = "pk",
            valueColumnName = "value", pkColumnValue = "app_purchase")
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "AppPurchaseIdTable")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Timestamp purchaseDate;

    @javax.persistence.Column(name = "purchase_date")
    @Basic
    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
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

    private UsersEntity user;

    @ManyToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    //@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    public UsersEntity getUser() {
        return user;
    }

    public void setUser(UsersEntity user) {
        this.user = user;
    }

    private ProductsEntity product;

    @ManyToOne(cascade = CascadeType.ALL)
    //@PrimaryKeyJoinColumn(name = "product_id", referencedColumnName = "id")
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    //@Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    public ProductsEntity getProduct() {
        return product;
    }

    public void setProduct(ProductsEntity product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseEntity that = (PurchaseEntity) o;

        if (id != that.id) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (purchaseDate != null ? !purchaseDate.equals(that.purchaseDate) : that.purchaseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (purchaseDate != null ? purchaseDate.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
