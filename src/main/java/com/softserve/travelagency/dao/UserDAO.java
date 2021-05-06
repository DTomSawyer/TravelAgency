package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;

import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();
    public List<Order> getOrdersByUserId(int userID);
}
