package com.java.learning.lld.diningtablebooking.service;


import com.java.learning.lld.diningtablebooking.entity.Order;
import com.java.learning.lld.diningtablebooking.entity.Table;

public class RobotService {
    private final OrderService orderService;
    private final BookingService bookingService;

    public RobotService(OrderService orderService, BookingService bookingService) {
        this.orderService = orderService;
        this.bookingService = bookingService;
    }

    public void deliverOrder(String orderId){
        Order order = orderService.fetchOrder(orderId);
        Table table = order.getBooking().getTable();
        System.out.println(String.format("Command to robot : -> Deliver order id : %s, to table : %s", orderId, table.getId()));
    }

    public void delivered(){
        //update order status to delivered
    }

    public void addTable(Table table){
        bookingService.addTable(table);
    }
}
