package com.test.javacourse.MarketPlace.controller;

import com.test.javacourse.MarketPlace.dto.OrderRequestDto;
import com.test.javacourse.MarketPlace.exceptionHandling.BusinessException;
import com.test.javacourse.MarketPlace.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/save")
    public void save(@RequestBody OrderRequestDto orderRequestDto) {
            orderService.save(orderRequestDto);
    }



    @DeleteMapping("/deleteOrderByOrderNumber")
    public void deleteOrderByOrderNumber(@RequestParam Long orderId){
       orderService.deleteOrderByOrderNumber(orderId);
    }
}
