package com.grupo1software.youngmiracles.dto;

import lombok.Data;

@Data
public class PaymentCaptureResponse {
    private boolean completed;
    private Integer purchaseId;
}
