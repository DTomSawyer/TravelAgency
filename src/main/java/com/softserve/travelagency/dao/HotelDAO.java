package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Hotel;

import java.util.List;

public interface HotelDAO {

    void saveHotel(Hotel hotel);

    Hotel getHotelById(Long id);

    List<Hotel> getHotelsByCountry(String country);

    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getAllHotels();

    void deleteHotelById(Long id);

    List<String> getAllCountries();
}
