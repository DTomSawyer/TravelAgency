package com.softserve.travelagency.dao;

import com.softserve.travelagency.model.Room;



import java.util.List;

public interface RoomDAO {

    void saveRoom(Room room);

    Room getRoomById(Long id);

    public List<Room> getAllRooms();

    public void delete(Long id);
}
