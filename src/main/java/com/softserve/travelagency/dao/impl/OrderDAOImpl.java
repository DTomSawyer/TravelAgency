package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.model.Order;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@AllArgsConstructor
public class OrderDAOImpl implements OrderDAO {

    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        session.flush();
    }

    @Override
    public Order getOrderById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Order.class, id);
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Order O WHERE O.user.id = :userId", Order.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }
}
