package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderDAO {

    void saveOrder(Order order);

    Optional<Order> getOrderById(Long id);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getOrdersByHotelId(Long hotelId);

    void deleteOrder(Long id);

}
