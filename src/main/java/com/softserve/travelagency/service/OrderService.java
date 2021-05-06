package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUserId(Long userId);

    void deleteOrderById(Long id);
}
