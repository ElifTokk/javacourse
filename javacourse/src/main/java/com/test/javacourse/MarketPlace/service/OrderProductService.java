package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import com.test.javacourse.MarketPlace.repository.OrderProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }


    public void save(OrderProduct orderProduct){
        orderProductRepository.save(orderProduct);
}
    public List<OrderProduct> findAllByOrder(Order order){
        return orderProductRepository.findAllByOrder(order);
    }

}
