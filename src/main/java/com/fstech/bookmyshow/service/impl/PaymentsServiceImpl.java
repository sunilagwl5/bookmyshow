package com.fstech.bookmyshow.service.impl;

import com.fstech.bookmyshow.service.PaymentService;
import org.springframework.stereotype.Service;

@Service("payment")
public class PaymentsServiceImpl implements PaymentService {
    @Override
    public Boolean makePayment(Boolean status) {
        return status;
    }

}
