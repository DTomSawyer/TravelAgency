package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(int id);

    public void delete(int id);

//    void delete2(User user);
}

