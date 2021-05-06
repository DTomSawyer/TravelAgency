package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;

import java.util.List;

public interface OrderDAO {
    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUserId(Long id);

    void deleteOrderById(Long id);
}
