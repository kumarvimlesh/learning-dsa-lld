/**

 1. Product management
 2. Search and filter for the products
 3. Add to cart
 4. Payment and its status
 5. Order and its status

 -------- Database design
 user
 id uuid(primary key),
 name varchar,
 email varchar,
 address varchar

 seller
 id uuid (primary key),
 name varchar

 product
 id uuid (primary key),
 name varchar
 price double
 description varchar(1000),
 seller_id uuid (foreign key references seller table)
 quantity int

 cart
 id uuid (pk),
 user_id

 cart_items
 id
 product_id,
 quantity,
 cart_id

 payment
 id,
 amount,
 status,
 mode : offline/online,
 user_id

 order
 id uuid (primary key),
 payment_id,
 user_id uuid (foreign key reference user table),
 status


 */


package com.java.learning.lld.marketplacesystem;

public class MarketPlaceApplication {
    public static void main(String[] args){
    }
}

