package com.softserve.travelagency.service;

import com.softserve.travelagency.model.User;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(int id);

    public void deleteUser(int id);

//    public void deleteUser2(User user);
}
