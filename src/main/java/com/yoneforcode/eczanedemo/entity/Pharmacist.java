package com.yoneforcode.eczanedemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pharmacists")
public class Pharmacist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phoneNumber;

    // Diğer alanlar ve ilişkiler
    // Örneğin:
    @OneToMany(mappedBy = "pharmacist")
    private List<Order> orders;

    // Getter ve setter metotları

    public Pharmacist() {
    }

    public Pharmacist(String name, String phoneNumber, List<Order> orders) {
        this.name = name;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Pharmacist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orders=" + orders +
                '}';
    }

}
