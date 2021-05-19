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

import java.time.LocalDate;

import java.util.List;
import java.util.Set;

@Repository
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
        Hotel hotel = session.find(Hotel.class, id);
        return hotel;
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel H WHERE H.country = :country", Hotel.class);
        query.setParameter("country", country);
        List<Hotel> hotel = query.getResultList();
        return hotel;
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel H WHERE H.city = :city", Hotel.class);
        query.setParameter("city", city);
        List<Hotel> hotel = query.getResultList();
        return hotel;
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM Hotel", Hotel.class);
        List<Hotel> hotel = query.getResultList();
        return hotel;
    }

    @Override
    public void deleteHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Hotel hotel = session.find(Hotel.class, id);
        session.remove(hotel);
    }

    @Override
    public Set<String> getAllCountries() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createNativeQuery("select country from hotels");
        Set<String> allSet = new HashSet<>();
        allSet.addAll(query.getResultList());
        return allSet;
    }
}
