package com.example.homework7.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public OrderModel getOrder(Integer id) {
        return orderRepository.findById(id).get();
    }

    public OrderModel updateOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    public Iterable<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

}
