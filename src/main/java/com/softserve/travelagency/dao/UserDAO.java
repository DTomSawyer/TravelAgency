package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();

    // moved to OrderDAO
    // List<Order> getOrdersByUserId(int userID);
}
