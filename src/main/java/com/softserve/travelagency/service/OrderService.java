package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    void addOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getOrdersByHotelId(Long hotelId);

    void deleteOrderById(Long id);

}
