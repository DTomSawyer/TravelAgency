package com.softserve.travelagency.service;

import com.softserve.travelagency.model.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserService {

    boolean addUser(User user);

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    void deleteUser(Long id);
}
