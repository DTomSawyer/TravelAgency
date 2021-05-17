package com.softserve.travelagency.service;

import com.softserve.travelagency.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public boolean saveUser(User user);

    public User getUserById(Long id);

    public void deleteUser(Long id);

    public User findByEmail(String email);

//    public void deleteUser2(User user);
}
