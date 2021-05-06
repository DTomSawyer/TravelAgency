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
    @Transactional
    public void addOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Override
    @Transactional
    public Order getOrderById(Long id) {
        return orderDAO.getOrderById(id);
    }

    @Override
    @Transactional
    public List<Order> getOrdersByUserId(Long userId) {
        return orderDAO.getOrdersByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteOrderById(Long id) {
        orderDAO.deleteOrderById(id);
    }
}
