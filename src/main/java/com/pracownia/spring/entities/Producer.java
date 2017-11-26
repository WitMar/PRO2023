package com.pracownia.spring.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Producer {

    @Id
    @GeneratedValue(generator = "gen")
    @SequenceGenerator(name = "gen", sequenceName = "producer_seq")
    @Column(name = "id")
    private int id;

    @Column
    String name;

    @Column
    String city;

    @OneToMany
    List<Product> products = new ArrayList<>();

    //required by Hibernate
    public Producer(){

    }

    public Producer(String name, String city, List<Product> products) {
        this.name = name;
        this.city = city;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
