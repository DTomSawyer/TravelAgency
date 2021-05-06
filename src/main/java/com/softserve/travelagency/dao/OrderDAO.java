package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;

import java.util.List;

public interface OrderDAO {
    public void save(Order order);

    public Order getOrderById(Long id);

    public List<Order> getOrdersByUserId(Long id);
}
