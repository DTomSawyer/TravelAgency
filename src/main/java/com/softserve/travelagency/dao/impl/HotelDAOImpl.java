package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

@Repository
@AllArgsConstructor
public class HotelDAOImpl implements HotelDAO {

    private SessionFactory sessionFactory;

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(hotel);
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
    public Set<String> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createNativeQuery("select country from hotels");
        Set<String> allSet = new HashSet<>();
        allSet.addAll(query.getResultList());

        transaction.commit();
        return allSet;
    }

    @Override
    public boolean getHotelByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createQuery("FROM Hotel H WHERE H.name = :name", Hotel.class);
        query.setParameter("name", name);

        List<Hotel> hotels = query.getResultList();
        transaction.commit();
        if(hotels.size() > 0){
            return true;
        } else return false;
    }
}
