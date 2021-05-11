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
        Room room = session.get(Room.class, id);
        transaction.commit();
        return room;
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query<Room> query = session.createQuery("delete from Room " +
                "where id =:roomId");
        query.setParameter("roomId", id);
        query.executeUpdate();
        transaction.commit();
    }

    @Override
    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                        LocalDate departureDate) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        javax.persistence.Query query = session.createQuery("FROM Room R " +
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

        transaction.commit();
        return availableRooms;
    }


/*@Override
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
}*/

    /*@Override
    public List<Room> getAvailableRooms(LocalDate arrivalDate, LocalDate departureDate) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createNativeQuery("select room_id from orders " +
                "where :arrivalDate between arrivalDate and departureDate " +
                "and :departureDate between arrivalDate and departureDate " +
                "and arrivalDate between :arrivalDate and :departureDate " +
                "and departureDate between :arrivalDate and :departureDate");
        query.setParameter("arrivalDate", arrivalDate);
        query.setParameter("departureDate", departureDate);
        List<Long> roomId = query.getResultList();
        List<Room> rooms = new ArrayList<>();
        for(Long room : roomId){
            rooms.add(session.get(Room.class,room));
        }

        transaction.commit();

        return rooms;
    }*/
}