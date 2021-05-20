package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Hotel;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    @Override
    public boolean addRoom(Room room) {
        if (Objects.nonNull(getRoomByHotelAndNumber(room.getHotel(), room.getNumber()))) {
            return false;
        }
        roomDAO.saveRoom(room);
        return true;
    }

    @Override
    public Room getRoomById(Long id) {
        return roomDAO.getRoomById(id).orElse(null);
    }

    @Override
    public Room getRoomByHotelAndNumber(Hotel hotel, Integer number) {
        return roomDAO.getRoomByHotelAndNumber(hotel, number).orElse(null);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public List<Room> getAvailableRooms(java.lang.String country, LocalDate arrivalDate, LocalDate departureDate) {
        return roomDAO.getAvailableRooms(country, arrivalDate, departureDate);
    }

    @Override
    public void deleteRoom(Long id) {
        roomDAO.deleteRoom(id);
    }

}
