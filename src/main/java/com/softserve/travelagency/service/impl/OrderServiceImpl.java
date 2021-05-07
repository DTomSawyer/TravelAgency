package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    @Override
    public void addOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
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
        orderDAO.deleteOrderById(id);
    }
}
