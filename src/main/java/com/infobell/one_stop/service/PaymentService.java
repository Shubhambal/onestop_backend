package com.infobell.one_stop.service;

import com.infobell.one_stop.model.Payment;

public interface PaymentService {

    Payment getPaymentById(int id);

    Payment createPayment(Payment payment);

    Payment updatePayment(int id, Payment payment);

    String deletePayment(int id);
}
