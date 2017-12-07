package com.pracownia.spring.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Product entity.
 */
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=Product.class)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String productId;

    @Column
    private String name;

    @Column
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY, cascade={CascadeType.PERSIST,  CascadeType.REMOVE})
    @JoinTable(name = "product_selles")
    private Set<Seller> sellers = new HashSet<>();

    //required by Hibernate
    public Product(){

    }

    public Product(String productId, String name, BigDecimal price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<Seller> sellers) {
        this.sellers = sellers;
    }
}
