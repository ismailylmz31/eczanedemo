package com.yoneforcode.eczanedemo.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    // Diğer alanlar ve ilişkiler
    // Örneğin:
     @OneToMany(mappedBy = "medicine")
     private List<Order> orders;

    // Getter ve setter metotları


    public Medicine() {
    }

    public Medicine(String name, double price, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orders=" + orders +
                '}';
    }
}
