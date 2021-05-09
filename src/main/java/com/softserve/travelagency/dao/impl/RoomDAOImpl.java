package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public RoomDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        List<Room> allRooms = session.createQuery("from Room", Room.class)
                .getResultList();
        transaction.commit();
        return allRooms;
    }

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
    }

    @Override
    public Room getRoomById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Room room = session.get(Room.class,id);
        transaction.commit();
        return room;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query<Room> query = session.createQuery("delete from Room " +
                "where id =:roomId");
        query.setParameter("roomId",id);
        query.executeUpdate();
        transaction.commit();
    }



public List<Room> getAvailableRooms(LocalDate arrivalDate, LocalDate departureDate) {
    Session session = sessionFactory.getCurrentSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("select r from Room r where r not" +
            " in (" +
            "select ro " +
            "from Order ro " +
            "where :arrivalDate between ro.arrivalDate and ro.departureDate " +
            "and :departureDate between ro.arrivalDate and ro.departureDate " +
            "and ro.arrivalDate between :arrivalDate and :departureDate " +
            "and ro.departureDate between :arrivalDate and :departureDate)");
    query.setParameter("arrivalDate", arrivalDate);
    query.setParameter("departureDate", departureDate);
    List<Room> room = query.getResultList();
    transaction.commit();

    return room;
}
}
