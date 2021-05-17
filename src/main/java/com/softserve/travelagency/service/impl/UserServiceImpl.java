package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.model.util.Role;
import com.softserve.travelagency.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public boolean saveUser(User user) {
        User userDB = userDAO.findByEmail(user.getEmail());

        if(userDB != null) {
            return false;
        }

        user.setRole(Role.USER);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

        userDAO.saveUser(user);
        return true;
    }

    @Override
    public User getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.delete(id);
    }

    @Override
    public User findByEmail(String email) {
        return userDAO.findByEmail(email);
    }
//    @Transactional
//    @Override
//    public void deleteUser2(User user) {
//        userDAO.delete(user);
//    }
}
