package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Order;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class OrderDAOImpl implements OrderDAO {

    private SessionFactory sessionFactory;

    @Override
    public void saveOrder(Order order) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.persist(order);
        session.flush();

        transaction.commit();
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Order order = session.find(Order.class, id);
            return Optional.of(order);
        } catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Order O WHERE O.user.id = :userId", Order.class);
            query.setParameter("userId", userId);
            return (List<Order>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Order> getOrdersByHotelId(Long hotelId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Order O WHERE O.hotel.id = :hotelId", Order.class);
            query.setParameter("hotelId", hotelId);
            return (List<Order>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deleteOrder(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Order order = session.find(Order.class, id);
        session.remove(order);

        transaction.commit();
    }

}
