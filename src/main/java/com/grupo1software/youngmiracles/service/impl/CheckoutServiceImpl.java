package com.grupo1software.youngmiracles.service.impl;

import com.grupo1software.youngmiracles.dto.FacturaResponseDTO;
import com.grupo1software.youngmiracles.dto.PaymentCaptureResponse;
import com.grupo1software.youngmiracles.dto.PaymentOrderResponse;
import com.grupo1software.youngmiracles.integration.payment.paypal.dto.OrderCaptureResponse;
import com.grupo1software.youngmiracles.integration.payment.paypal.dto.OrderResponse;
import com.grupo1software.youngmiracles.integration.payment.paypal.service.PayPalService;
import com.grupo1software.youngmiracles.service.AdminFacturaService;
import com.grupo1software.youngmiracles.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final PayPalService payPalService;
    private final AdminFacturaService adminFacturaService;
    @Override
    public PaymentOrderResponse createPayment(Long facturaId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = payPalService.createOrder(Math.toIntExact(facturaId), returnUrl, cancelUrl);
        String paypalUrl = orderResponse
                .getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approve"))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getHref();
        return new PaymentOrderResponse(paypalUrl);
    }

    @Override
    public PaymentCaptureResponse capturePayment(String orderId) {
        OrderCaptureResponse orderCaptureResponse = payPalService.captureOrder(orderId);
        boolean completed = orderCaptureResponse.getStatus().equals("COMPLETED");
        PaymentCaptureResponse paypalCaptureResponse = new PaymentCaptureResponse();
        paypalCaptureResponse.setCompleted(completed);
        if (completed) {
            String purchaseIdStr = orderCaptureResponse.getPurchaseUnits().get(0).getReferenceId();

            FacturaResponseDTO invoiceDetailsDTO = adminFacturaService.confirmPurchase((long) Integer.parseInt(purchaseIdStr));
            paypalCaptureResponse.setPurchaseId(Math.toIntExact(invoiceDetailsDTO.getFacturaId()));

            //sendPurchaseConfirmationEmail(purchaseDTO);
        }

        return paypalCaptureResponse;
    }
}
