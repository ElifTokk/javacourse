package com.test.javacourse.MarketPlace.service;


import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.Users;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SmsService {
    @Async
    public void sendSmsUser(Order order, Users user) {

        ReplaceFunction replaceFunction = (template, name, orderNumber) -> template.replace("NAME", name).replace("ORDERNUMBER", orderNumber);

        String orderNumber = order.getOrderNumber();
        String name = user.getName();
        String phoneNumber = user.getPhoneNumber();

        if (StringUtils.hasText(orderNumber)) {
            String smsBody = "Sevgili NAME siparişini aldık.Sipariş numarası : ORDERNUMBER";
            replaceFunction.replace(smsBody, name, orderNumber);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
