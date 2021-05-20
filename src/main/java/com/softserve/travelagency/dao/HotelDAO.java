package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Hotel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HotelDAO {

    void saveHotel(Hotel hotel);

    Optional<Hotel> getHotelById(Long id);

    Optional<Hotel> getHotelByName(String name);

    List<Hotel> getHotelsByCountry(String country);

    /*List<Hotel> getHotelsByCity(String city);*/

    List<Hotel> getAllHotels();

    void deleteHotel(Long id);

    Set<String> getAllCountries();


}
