package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UserDAO {

    void saveUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);

}

