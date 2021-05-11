package com.softserve.travelagency.service;

import com.softserve.travelagency.model.Room;
import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    public void saveRoom(Room room);

    public Room getRoomById(Long id);

    public List<Room> getAllRooms();

    public List<Room> getAvailableRooms(String country, LocalDate arrivalDate,
                                        LocalDate departureDate);

    public void deleteRoom(Long id);
}
