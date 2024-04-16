package com.test.javacourse.MarketPlace.service;

import com.test.javacourse.MarketPlace.dto.OrderRequestDto;
import com.test.javacourse.MarketPlace.entity.Order;
import com.test.javacourse.MarketPlace.entity.OrderProduct;
import com.test.javacourse.MarketPlace.entity.Product;
import com.test.javacourse.MarketPlace.entity.Users;
import com.test.javacourse.MarketPlace.exceptionHandling.BusinessException;
import com.test.javacourse.MarketPlace.repository.OrderRepository;
import com.test.javacourse.MarketPlace.service.shipping.MNGShippingStrategy;
import com.test.javacourse.MarketPlace.service.shipping.SRTShippingStrategy;
import com.test.javacourse.MarketPlace.service.shipping.ShippingCostCalculator;
import com.test.javacourse.MarketPlace.service.shipping.YRTShippingStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
    public void save(OrderRequestDto orderRequestDto) {
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

        getCargoOffer(order, users);
    }

    public void getCargoOffer(Order order, Users users) {


        Order orders = orderRepository.findById(order.getId()).get();
        List<OrderProduct> orderProductList = orderProductService.findAllByOrder(orders);

        int totalWeigth = 0;
        for (OrderProduct orderProduct : orderProductList) {
            Product product = orderProduct.getProduct();
            int weight = product.getWeight();
            totalWeigth += weight;

        }
        ShippingCostCalculator calculator = null;

        if (users.isPremium()) {
            calculator = new ShippingCostCalculator(new MNGShippingStrategy());
            System.out.println("MNG Shipping Cost: " + calculator.calculateCost(totalWeigth));
            order.setTotalAmount(calculator.calculateCost(totalWeigth));
            return;
        }

        if (totalWeigth > 200) {
            throw new BusinessException("Ürün ağırlığı fazla.Lütfen farklı bir kargo seçeneği ile ilerleyin");
        }

        calculate(order, totalWeigth);

    }

    private void calculate(Order order, int totalWeigth) {
        ShippingCostCalculator calculator;
        if (totalWeigth > 0 && totalWeigth <= 100) {
            calculator = new ShippingCostCalculator(new SRTShippingStrategy());
            order.setTotalAmount(calculator.calculateCost(totalWeigth));

        } else if (totalWeigth > 100 && totalWeigth < 200) {
            calculator = new ShippingCostCalculator(new YRTShippingStrategy());
            order.setTotalAmount(calculator.calculateCost(totalWeigth));

        }
    }

    public void sendSms(Order order, Users user) throws Exception {

        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new BusinessException("Telefon numaranız sistemde kayıtlı olmadığı için sipariş oluşturulamadı!");
        } else {
            smsService.sendSmsUser(order, user);
        }


    }


    public void deleteOrderByOrderNumber(Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        orderRepository.delete(order);
    }


}
