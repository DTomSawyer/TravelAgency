package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(Long id);

    public void delete(Long id);

    public User findByEmail(String email);

//    void delete2(User user);
}

