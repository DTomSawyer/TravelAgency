package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public List<User> getAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class)
                .getResultList();
        return allUsers;
    }

    /*@Override
    public List<Order> getOrdersByUserId(int userId) {
        Session session = sessionFactory.getCurrentSession();
        List<Order> allOrdersByUserId = session.createQuery("from Order", Order.class)
                .getResultList();
        return allOrdersByUserId;
    }*/
}
