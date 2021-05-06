package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Room;
import com.softserve.travelagency.model.User;


import java.util.List;

public interface RoomService {

    public List<Room> getAllRooms();

    public void saveRoom(Room room);

    public User getRoomById(Long id);

    public void deleteRoom(Long id);
}
