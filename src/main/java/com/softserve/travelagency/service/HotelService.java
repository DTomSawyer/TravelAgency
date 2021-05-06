package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Hotel;

import java.util.List;

public interface HotelService {
    void addHotel(Hotel hotel);

    Hotel getHotelById(Long id);

    List<Hotel> getHotelsByCountry(String country);

    List<Hotel> getHotelsByCity(String city);

    List<Hotel> getAllHotels();

    void deleteHotelById(Long id);
}
