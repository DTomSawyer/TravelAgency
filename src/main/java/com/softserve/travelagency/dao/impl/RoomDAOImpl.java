package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
public class RoomDAOImpl implements RoomDAO {

    private final SessionFactory sessionFactory;

    @Override
    public void saveRoom(Room room) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(room);

        transaction.commit();
    }

    @Override
    public Optional<Room> getRoomById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Room room = session.get(Room.class, id);
            return Optional.of(room);
        } catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public Optional<Room> getRoomByHotelAndNumber(Hotel hotel, Integer number) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Query query = session.createQuery("FROM Room R WHERE R.hotel = :hotel " +
                    "AND R.number = :number", Room.class);
            query.setParameter("hotel", hotel);
            query.setParameter("number", number);

            List result = query.getResultList();
            if (result.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of((Room) result.get(0));
        } catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Room> getAllRooms() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("from Room", Room.class);
            return (List<Room>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                        LocalDate departureDate) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Room R " +
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

            return (List<Room>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deleteRoom(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM Room WHERE id =:roomId");
        query.setParameter("roomId", id);

        query.executeUpdate();
        transaction.commit();
    }
}