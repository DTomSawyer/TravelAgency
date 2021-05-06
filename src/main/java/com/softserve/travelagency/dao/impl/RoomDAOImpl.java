package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        List<Room> allRooms = session.createQuery("from Room", Room.class)
                .getResultList();
        return allRooms;
    }
}
