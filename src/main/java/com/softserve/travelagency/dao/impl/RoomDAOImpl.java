package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
        List<Room> allRooms = session.createQuery("from Room", Room.class)
                .getResultList();
        return allRooms;
    }

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        session.save(room);
    }

    @Override
    public Room getRoomById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Room room = session.get(Room.class, id);
        return room;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Room> query = session.createQuery("delete from Room " +
                "where id =:roomId");
        query.setParameter("roomId", id);
        query.executeUpdate();
    }

    @Override
    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                        LocalDate departureDate) {

        Session session = sessionFactory.getCurrentSession();
        javax.persistence.Query query =
                session.createQuery("FROM Room R " +
                "WHERE R.hotel.country = :country " +
                "AND R.id NOT IN " +
                "(SELECT O.room.id FROM Order O " +
                "WHERE :arrivalDate BETWEEN O.arrivalDate AND O.departureDate " +
                "OR :departureDate BETWEEN O.arrivalDate AND O.departureDate " +
                "OR O.arrivalDate BETWEEN :arrivalDate AND :departureDate " +
                "OR O.departureDate BETWEEN :arrivalDate AND :departureDate)", Room.class);
        query.setParameter("country", country);
        query.setParameter("arrivalDate", arrivalDate);
        query.setParameter("departureDate", departureDate);
        List<Room> availableRooms = query.getResultList();
        return availableRooms;
    }
}