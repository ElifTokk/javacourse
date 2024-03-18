package com.test.javacourse.MarketPlace.controller;

import com.test.javacourse.MarketPlace.dto.OrderProductSaveRequestDto;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import com.test.javacourse.MarketPlace.service.OrderProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/orderProductController")
public class OrderProductController {

    private final OrderProductService orderProductService;


    public OrderProductController(OrderProductService orderProductService) {
        this.orderProductService = orderProductService;
    }


}
