package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Hotel;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface HotelService {
    boolean addHotel(Hotel hotel);

    Optional<Hotel> getHotelById(Long id);

    List<Hotel> getHotelsByCountry(String country);

    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getAllHotels();

    void deleteHotelById(Long id);

    Set<String> getAllCountries();

}
