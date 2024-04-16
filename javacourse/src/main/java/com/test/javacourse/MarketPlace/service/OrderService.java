package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.dto.OrderRequestDto;
import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import com.test.javacourse.MarketPlace.entity.Product;
import com.test.javacourse.MarketPlace.entity.Users;
import com.test.javacourse.MarketPlace.exceptionHandling.BusinessException;
import com.test.javacourse.MarketPlace.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductService productService;

    private final OrderProductService orderProductService;

    private final UserService userService;


    private final SmsService smsService;


    public OrderService(OrderRepository orderRepository, ProductService productService, OrderProductService orderProductService, UserService userService, SmsService smsService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.userService = userService;
        this.smsService = smsService;
    }

    @Transactional
    public void save(OrderRequestDto orderRequestDto)  {
        Order order = new Order();
        order.setOrderDescription(orderRequestDto.getOrderDescription());


        Optional<Users> user = userService.findUserById(orderRequestDto.getUserId());
        Users users = user.orElseThrow(() -> new RuntimeException("Verdiğiniz ID ye ait kullanıcı bulunamamaktadır!"));
        order.setUsers(users);
        orderRepository.save(order);
        Product product = productService.findByProductId(orderRequestDto.getProductId());

        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);

        orderProductService.save(orderProduct);

        try {
            sendSms(order, users);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



    public void sendSms(Order order, Users user) throws Exception {

        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new BusinessException("Telefon numaranız sistemde kayıtlı olmadığı için sipariş oluşturulamadı!");
        }else {
            smsService.sendSmsUser(order, user);
        }


    }


    public void deleteOrderByOrderNumber(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        orderRepository.delete(order);
    }


}
