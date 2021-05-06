package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.UserDAO;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User", User.class)
                .getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,id);
        return user;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User " +
                "where id =:userId");
        query.setParameter("userId",id);
        query.executeUpdate();
    }
//    @Override
//    public void delete2(User user) {
//        Session session = sessionFactory.getCurrentSession();
//        session.delete(user);
//    }
}
