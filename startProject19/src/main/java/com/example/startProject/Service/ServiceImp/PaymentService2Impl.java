package com.example.startProject.Service.ServiceImp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("PaymentService2Impl")
public class PaymentService2Impl implements paymentService {
    private static org.slf4j.Logger Logger  = LoggerFactory.getLogger(PaymentServiceImp.class);


    @Override
    public void printMessage() {
        Logger.info("In PaymentService2Imp ");
    }
}
