package com.java.learning.lld.foodDeliverySystem.service;

import com.java.learning.lld.foodDeliverySystem.dto.PaymentDetails;

public interface PaymentService {
    PaymentDetails initiatePayment(double amount, PaymentDetails paymentDetails);
    PaymentDetails checkDetails(String transactionId);
}
