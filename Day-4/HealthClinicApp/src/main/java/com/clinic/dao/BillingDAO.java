package com.clinic.dao;

import com.clinic.dto.Billing;

import java.util.List;

public interface BillingDAO {

    int insertBilling(Billing billing);

    boolean updateBilling(Billing billing);

    boolean deleteBilling(int billId);

    Billing getBillingById(int billId);

    Billing getBillingByAppointmentId(int appointmentId);

    List<Billing> getAllBillings();

    boolean updatePaymentStatus(int billId, String paymentStatus);

}