package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.dto.OrderRequestDto;
import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import com.test.javacourse.MarketPlace.entity.Product;
import com.test.javacourse.MarketPlace.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    private final OrderProductService orderProductService;


    public OrderService(OrderRepository orderRepository, ProductService productService, OrderProductService orderProductService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductService = orderProductService;
    }


    public void save(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderDescription(orderRequestDto.getOrderDescription());
        orderRepository.save(order);
        Product product = productService.findByProductId(orderRequestDto.getProductId());

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);

        orderProductService.save(orderProduct);


    }


    public void deleteOrderByOrderNumber(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        orderRepository.delete(order);
    }


}
