package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;


    @Override
    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }

    @Override
    public List<Room> getAvailableRooms(java.lang.String country, LocalDate arrivalDate, LocalDate departureDate) {
        return roomDAO.getAvailableRooms(country, arrivalDate, departureDate);
    }

    @Override
    public void addRoom(Room room) {
        roomDAO.saveRoom(room);
    }

    @Override
    public Room getRoomById(Long id) {
        return roomDAO.getRoomById(id);
    }

    @Override
    public void deleteRoom(Long id) {
        roomDAO.delete(id);
    }

}
