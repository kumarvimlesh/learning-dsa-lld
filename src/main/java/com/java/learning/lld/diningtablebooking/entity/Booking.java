package com.java.learning.lld.diningtablebooking.entity;

public class Booking {
    private String id;
    private int peopleCount;
    private Table table;

    public Booking(String id, int peopleCount, Table table) {
        this.id = id;
        this.peopleCount = peopleCount;
        this.table = table;
    }

    public String getId() {
        return id;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public Table getTable() {
        return table;
    }
}
