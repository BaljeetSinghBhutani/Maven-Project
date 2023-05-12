package com.example.startProject.Service.ServiceImp;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service("PaymentServiceImpl")
@Primary
public class PaymentServiceImp implements paymentService{

    private static Logger Logger  = LoggerFactory.getLogger(PaymentServiceImp.class);

    @Override
    public void printMessage() {

        Logger.info("In payment Service Imp");
    }
}
