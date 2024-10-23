package com.grupo1software.youngmiracles.service;

import com.grupo1software.youngmiracles.dto.PaymentCaptureResponse;
import com.grupo1software.youngmiracles.dto.PaymentOrderResponse;

public interface CheckoutService {

    PaymentOrderResponse createPayment(Long facturaId, String returnUrl, String cancelUrl);
    PaymentCaptureResponse capturePayment(String orderId);
}
