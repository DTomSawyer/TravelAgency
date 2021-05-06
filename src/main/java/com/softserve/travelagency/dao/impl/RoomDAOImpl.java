package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class RoomDAOImpl implements RoomDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public RoomDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
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
        Query<User> query = session.createQuery("delete from Room " +
                "where id =:roomId");
        query.setParameter("roomId",id);
        query.executeUpdate();
        transaction.commit();
    }
}
