package com.java.learning.lld.marketplacesystem;

import org.apache.catalina.User;

public interface PaymentService {
    Payment makePayment(Payment payment);
    Payment getPayment(String paymentId);
}
