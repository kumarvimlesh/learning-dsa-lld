package com.java.learning.lld.rateLimiter.fixedwindow;

import lombok.Data;

@Data
public class Resource {
    private int data;

    public Resource(int data) {
        this.data = data;
    }

    public void read(){
        System.out.println("Data is : "+ this.data);
    }
}
