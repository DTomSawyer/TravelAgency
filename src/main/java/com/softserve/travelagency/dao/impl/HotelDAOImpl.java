package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
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
public class HotelDAOImpl implements HotelDAO {

    private SessionFactory sessionFactory;

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.persist(hotel);
        session.flush();

        transaction.commit();
    }

    @Override
    public Hotel getHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Hotel hotel = session.find(Hotel.class, id);

        transaction.commit();
        return hotel;
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Hotel H WHERE H.country = :country", Hotel.class);
        query.setParameter("country", country);
        List<Hotel> hotel = query.getResultList();
        transaction.commit();
        return hotel;
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Hotel H WHERE H.city = :city", Hotel.class);
        query.setParameter("city", city);
        List<Hotel> hotel = query.getResultList();
        transaction.commit();
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Hotel", Hotel.class);
        List<Hotel> hotel = query.getResultList();
        transaction.commit();
        return hotel;
    }

    @Override
    public void deleteHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Hotel hotel = session.find(Hotel.class, id);
        session.remove(hotel);

        transaction.commit();
    }

    @Override
    public List<String> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNativeQuery("select country from hotels");
        List<String> allCountries = query.getResultList();

        transaction.commit();

        return allCountries;
    }
}
