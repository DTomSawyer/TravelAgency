package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.OrderDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

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
    public Order getOrderById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Order order = session.find(Order.class, id);

        transaction.commit();
        return order;
    }

    @Override
    public List<Order> getOrdersByUserId(Long userId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Order O WHERE O.user.id = :userId", Order.class);
        query.setParameter("userId", userId);
        List<Order> order = query.getResultList();
        transaction.commit();
        return order;
    }

    @Override
    public List<Order> getOrdersByHotelId(Long hotelId) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Order O WHERE O.hotel.id = :hotelId", Order.class);
        query.setParameter("hotelId", hotelId);
        List<Order> order = query.getResultList();
        transaction.commit();
        return order;
    }

    @Override
    public List<Room> getByHotelIdAndDates(Long hotelId, LocalDate arrivalDate,
                                           LocalDate departureDate) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("SELECT FROM Room R WHERE R NOT IN " +
                "(SELECT Order.rooms FROM Order O WHERE O.hotel.id = :hotelId" +
                "AND O.arrivalDate > :arrivalDate" +
                "AND O.departureDate > :departureDate)", Room.class);

        query.setParameter("arrivalDate", arrivalDate);
        query.setParameter("departureDate", departureDate);

        transaction.commit();
        return query.getResultList();
    }

    @Override
    public void deleteOrderById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Order order = session.find(Order.class, id);
        session.remove(order);

        transaction.commit();
    }
}
