package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Room;



import java.util.List;

public interface RoomService {

    public List<Room> getAllRooms();

    public void saveRoom(Room room);

    public Room getRoomById(Long id);

    public void deleteRoom(Long id);
}
