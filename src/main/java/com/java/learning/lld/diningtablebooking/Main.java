package com.java.learning.lld.diningtablebooking;


import com.java.learning.lld.diningtablebooking.entity.Booking;
import com.java.learning.lld.diningtablebooking.entity.MenuItem;
import com.java.learning.lld.diningtablebooking.entity.OrderItem;
import com.java.learning.lld.diningtablebooking.entity.Table;
import com.java.learning.lld.diningtablebooking.service.BookingService;
import com.java.learning.lld.diningtablebooking.service.OrderService;
import com.java.learning.lld.diningtablebooking.service.RobotService;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BookingService bookingService = new BookingService();
        OrderService orderService = new OrderService();
        RobotService robotService = new RobotService(orderService, bookingService);

        robotService.addTable(new Table(1, 4, true));
        robotService.addTable(new Table(2, 2, true));

        MenuItem pizza = new MenuItem(1, "Pizza", 200);
        MenuItem burger = new MenuItem(2, "Burger", 100);

        Booking booking = bookingService.bookTable(4);
        System.out.println("Table booked : " + booking.getTable().getId());


//        orderService.creatOrder(booking, List.of())
    }
}

/*
Table booking
Capacity
Order food
Menu items
Lifecycle



Booking table n people
Allocation of the table
Ordering of food
Track order


Robot->
Order delivery -> deliver to table


Tables-> capacity, availability
Booking -> table reservation
Food menus -> list items
Order -> orders
OrderItem -> order items

 */



