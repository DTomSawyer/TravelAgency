package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.util.Role;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean addUser(User user) {
        Optional<User> userDB = userDAO.getUserByEmail(user.getEmail());

        if (userDB.isPresent()) {
            return false;
        }

        user.setRole(Role.USER);
        user.setEncryptedPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userDAO.saveUser(user);
        return true;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }
}
