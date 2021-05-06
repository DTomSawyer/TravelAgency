package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Order;
import com.softserve.travelagency.model.User;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
public class HotelDAOImpl implements HotelDAO {

    private SessionFactory sessionFactory;

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(hotel);
        session.flush();
    }

    @Override
    public Hotel getHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.find(Hotel.class, id);
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel H WHERE H.country = :country", Hotel.class);
        query.setParameter("country", country);
        return query.getResultList();
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel H WHERE H.city = :city", Hotel.class);
        query.setParameter("city", city);
        return query.getResultList();
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Hotel", Hotel.class).getResultList();
    }

    @Override
    public void deleteHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.find(Hotel.class, id);
        session.remove(hotel);
    }
}
