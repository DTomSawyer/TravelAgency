package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Override
    public void addOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id).orElse(null);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByHotelId(Long hotelId) {
        return orderDAO.getOrdersByHotelId(hotelId);
    }

    @Override
    public void deleteOrderById(Long id) {
        orderDAO.deleteOrder(id);
    }
}
