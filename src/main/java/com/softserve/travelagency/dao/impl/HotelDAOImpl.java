package com.softserve.travelagency.dao.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

import java.util.*;


@Repository
@AllArgsConstructor
public class HotelDAOImpl implements HotelDAO {

    private final SessionFactory sessionFactory;

    @Override
    public void saveHotel(Hotel hotel) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        session.save(hotel);
        transaction.commit();
    }

    @Override
    public Optional<Hotel> getHotelById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            Hotel hotel = session.find(Hotel.class, id);
            return Optional.of(hotel);
        } catch (NullPointerException npe) {
            return Optional.empty();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Hotel H WHERE H.country = :country", Hotel.class);
            query.setParameter("country", country);
            return (List<Hotel>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Hotel H WHERE H.city = :city", Hotel.class);
            query.setParameter("city", city);
            return (List<Hotel>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createQuery("FROM Hotel", Hotel.class);
            return (List<Hotel>) query.getResultList();
        } catch (NullPointerException npe) {
            return new ArrayList<>();
        } finally {
            transaction.commit();
        }
    }

    @Override
    public void deleteHotel(Long id) {
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

        try {
            @SuppressWarnings("unchecked")
            Query query = session.createNativeQuery("SELECT country FROM hotels");
            return new HashSet<>(query.getResultList());
        } catch (NullPointerException npe) {
            return new HashSet<>();
        } finally {
            transaction.commit();
        }
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
