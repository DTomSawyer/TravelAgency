package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;

import java.time.LocalDate;
import java.util.List;

public interface OrderDAO {
    void saveOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getOrdersByUserId(Long userId);

    List<Order> getOrdersByHotelId(Long hotelId);

    List<Room> getByHotelIdAndDates(Long hotelId, LocalDate arrivalDate,
                                    LocalDate departureDate);

    void deleteOrderById(Long id);
}
