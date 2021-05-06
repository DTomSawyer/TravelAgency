package com.softserve.travelagency.service.impl;


import com.softserve.travelagency.dao.RoomDAO;
import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;
import com.softserve.travelagency.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomDAO roomDAO;

    @Autowired
    public RoomServiceImpl(RoomDAO roomDAO) {
        this.roomDAO = roomDAO;
    }

    @Transactional
    @Override
    public List<Room> getAllRooms(){
       return roomDAO.getAllRooms();
    }
    @Transactional
    @Override
    public void saveRoom(Room room) {

    }
    @Transactional
    @Override
    public Room getRoomById(Long id) {
        return null;
    }
    @Transactional
    @Override
    public void deleteRoom(Long id) {

    }
}
