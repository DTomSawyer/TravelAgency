package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;

import java.util.List;

public interface OrderDAO {
    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getOrdersByHotelId(Long hotelId);

    void deleteOrderById(Long id);
}
