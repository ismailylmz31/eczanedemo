package com.yoneforcode.eczanedemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

     @ManyToOne
     @JoinColumn(name = "pharmacist_id")
     private Pharmacist pharmacist;

     @ManyToOne
     @JoinColumn(name = "customer_id")
     private Customer customer;

     @ManyToOne
     @JoinColumn(name = "medicine_id")
     private Medicine medicine;

    // Diğer alanlar

    // Getter ve setter metotları
    public Order() {

    }

    public Order(Pharmacist pharmacist, Customer customer, Medicine medicine) {
        this.pharmacist = pharmacist;
        this.customer = customer;
        this.medicine = medicine;
    }



    public Pharmacist getPharmacist() {
        return pharmacist;
    }

    public void setPharmacist(Pharmacist pharmacist) {
        this.pharmacist = pharmacist;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", pharmacist=" + pharmacist +
                ", customer=" + customer +
                ", medicine=" + medicine +
                '}';
    }
}
