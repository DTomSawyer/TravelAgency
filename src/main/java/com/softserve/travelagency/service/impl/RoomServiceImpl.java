package com.softserve.travelagency.service.impl;

import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Override
    public List<Room> getAllRooms(){
       return roomDAO.getAllRooms();
    }

    @Override
    public List<Room> getAvailableRooms(java.lang.String country, LocalDate arrivalDate, LocalDate departureDate) {
        return roomDAO.getAvailableRooms(country, arrivalDate, departureDate);
    }

    @Override
    public void saveRoom(Room room) {
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
