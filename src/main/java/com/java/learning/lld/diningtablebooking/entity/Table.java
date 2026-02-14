package com.java.learning.lld.diningtablebooking.entity;


public class Table {
    private int id;
    private int capacity;
    private boolean isAvailable;

    public Table(int id, int capacity, boolean isAvailable) {
        this.id = id;
        this.capacity = capacity;
        this.isAvailable = isAvailable;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
