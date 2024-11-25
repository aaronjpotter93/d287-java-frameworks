package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class NonGrocery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    String name;

    @Min(value = 0, message = "Price value must be positive")
    double price;

    @Min(value = 0, message = "Inventory value must be positive")
    int inv;

    @Min(value = 0, message = "Minimum value must be positive")
    int minInv;

    int maxInv;

    public NonGrocery() {}

    public Long getId() {
        return id;
    }

    public void setId(long id) {
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

    public int getInv() {
        return inv;
    }

    public void setInv(int inv) {
        this.inv = inv;
    }

    public int getMinInv() {
        return minInv;
    }

    public void setMinInv(int minInv) {
        this.minInv = minInv;
    }

    public int getMaxInv() {
        return maxInv;
    }

    public void setMaxInv(int maxInv) {
        this.maxInv = maxInv;
    }

    @Override
    public String toString() {
        return "NonGrocery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", inv=" + inv +
                ", minInv=" + minInv +
                ", maxInv=" + maxInv +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NonGrocery nonGrocery = (NonGrocery) o;

        return id == nonGrocery.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
