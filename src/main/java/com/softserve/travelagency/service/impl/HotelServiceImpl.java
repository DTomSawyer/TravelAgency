package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelDAO hotelDAO;

    @Override
    @Transactional
    public void addHotel(Hotel hotel) {
        hotelDAO.saveHotel(hotel);
    }

    @Override
    @Transactional
    public Hotel getHotelById(Long id) {
        return hotelDAO.getHotelById(id);
    }

    @Override
    @Transactional
    public List<Hotel> getHotelsByCountry(String country) {
        return hotelDAO.getHotelsByCountry(country);
    }

    @Override
    @Transactional
    public List<Hotel> getHotelsByCity(String city) {
        return hotelDAO.getHotelsByCity(city);
    }

    @Override
    @Transactional
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }

    @Override
    @Transactional
    public void deleteHotelById(Long id) {
        hotelDAO.deleteHotelById(id);
    }
}
