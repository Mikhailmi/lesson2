package ru.gb.lesson2;

public class Product {

private long id;
private String name;
private int price;

    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }
}
