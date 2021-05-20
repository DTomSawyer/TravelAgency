package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.HotelDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.service.HotelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private HotelDAO hotelDAO;

    @Override
    public boolean addHotel(Hotel hotel) {

        if (hotelDAO.getHotelByName(hotel.getName())) {
            return false;
        }
        hotelDAO.saveHotel(hotel);
        return  true;


    @Override
    public Optional<Hotel> getHotelById(Long id) {
        return hotelDAO.getHotelById(id);
    }

    @Override
    public List<Hotel> getHotelsByCountry(String country) {
        return hotelDAO.getHotelsByCountry(country);
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        return hotelDAO.getHotelsByCity(city);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelDAO.getAllHotels();
    }

    @Override
    public void deleteHotelById(Long id) {
        hotelDAO.deleteHotel(id);
    }

    @Override
    public Set<String> getAllCountries() {
        return hotelDAO.getAllCountries();
    }
}
