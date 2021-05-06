package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Room;



import java.util.List;

public interface RoomDAO {

    public List<Room> getAllRooms();

    public void saveRoom(Room room);

    public Room getRoomById(Long id);

    public void delete(Long id);
}
